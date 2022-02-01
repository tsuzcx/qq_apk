package com.tencent.aelight.camera.aioeditor.capture.control;

import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.CaptureContext;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAllFullMusicInfoTask
  extends ParallGroup
{
  private QIMMusicConfigManager f = (QIMMusicConfigManager)QIMManager.a(2);
  private String g;
  private List<FlowMusic> h = null;
  private List<FlowMusic> i = new ArrayList();
  private List<FlowMusic> j = new ArrayList();
  
  private void b()
  {
    Object localObject1 = this.mParams;
    int n = 0;
    this.g = ((String)localObject1[0]);
    localObject1 = this.f.d.query(FlowMusic.class);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      this.h = new ArrayList((Collection)localObject1);
      k = this.h.size();
    }
    else
    {
      k = 0;
    }
    Object localObject2;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("load db, has load local, size=");
      ((StringBuilder)localObject1).append(k);
      QLog.d("GetAllFullMusicInfoTask", 2, ((StringBuilder)localObject1).toString());
      localObject1 = this.h;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FlowMusic)((Iterator)localObject1).next();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("load db, local music=");
          ((StringBuilder)localObject3).append(localObject2);
          QLog.d("GetAllFullMusicInfoTask", 2, ((StringBuilder)localObject3).toString());
        }
      }
    }
    try
    {
      localObject1 = new JSONObject(this.g);
      if (((JSONObject)localObject1).optInt("ret", -1) != 0) {
        break label581;
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("song_list");
      if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
        break label581;
      }
      localObject2 = new HashSet();
      if (this.h == null) {
        break label582;
      }
      k = this.h.size();
    }
    catch (JSONException localJSONException)
    {
      long l;
      if (!QLog.isColorLevel()) {
        break label581;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("can not parse json, json = ");
      ((StringBuilder)localObject2).append(this.g);
      QLog.e("GetAllFullMusicInfoTask", 2, ((StringBuilder)localObject2).toString(), localJSONException);
    }
    int m = k;
    if (((JSONArray)localObject1).length() < k) {
      m = ((JSONArray)localObject1).length();
    }
    l = System.currentTimeMillis();
    int k = n;
    for (;;)
    {
      if (k < m)
      {
        localObject3 = ((JSONArray)localObject1).optJSONObject(k);
        if (localObject3 != null)
        {
          FlowMusic localFlowMusic = new FlowMusic();
          localFlowMusic.albumId = ((JSONObject)localObject3).optInt("album_id");
          localFlowMusic.albumMid = ((JSONObject)localObject3).optString("album_mid");
          localFlowMusic.albumName = ((JSONObject)localObject3).optString("album_name");
          localFlowMusic.singerId = ((JSONObject)localObject3).optInt("singer_id");
          localFlowMusic.singerMid = ((JSONObject)localObject3).optString("singer_mid");
          localFlowMusic.singerName = ((JSONObject)localObject3).optString("singer_name");
          localFlowMusic.songId = ((JSONObject)localObject3).optInt("song_id");
          localFlowMusic.songMid = ((JSONObject)localObject3).optString("song_mid");
          localFlowMusic.songName = ((JSONObject)localObject3).optString("song_name");
          localFlowMusic.songPlayTime = ((JSONObject)localObject3).optInt("song_play_time");
          localFlowMusic.userOwnRule = ((JSONObject)localObject3).optInt("user_own_rule");
          localFlowMusic.sourceType = 1;
          localFlowMusic.storeTimeStamp = (m + l - k);
          if ((!TextUtils.isEmpty(localFlowMusic.songMid)) && ((this.h == null) || (!this.h.contains(localFlowMusic)))) {
            ((Set)localObject2).add(localFlowMusic);
          }
        }
      }
      else
      {
        this.j.addAll((Collection)localObject2);
        return;
        label581:
        return;
        label582:
        k = 0;
        m = 40 - k;
        k = m;
        if (m <= 20) {
          break;
        }
        k = 20;
        break;
      }
      k += 1;
    }
  }
  
  private void c()
  {
    if (!this.i.isEmpty())
    {
      localObject1 = this.f.d.getTransaction();
      try
      {
        ((EntityTransaction)localObject1).begin();
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          FlowMusic localFlowMusic = (FlowMusic)localIterator.next();
          this.f.d.persistOrReplace(localFlowMusic);
        }
        ((EntityTransaction)localObject1).commit();
        ((EntityTransaction)localObject1).end();
        this.f.a(4, true, this.i);
      }
      finally
      {
        ((EntityTransaction)localObject1).end();
      }
    }
    Object localObject1 = this.f;
    QIMMusicConfigManager.c(CaptureContext.a().getCurrentAccountUin());
  }
  
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    try
    {
      if ((paramAsyncStep instanceof GetSingleFullMusicInfoTask))
      {
        FlowMusic localFlowMusic = ((GetSingleFullMusicInfoTask)paramAsyncStep).b;
        if (localFlowMusic == null)
        {
          paramAsyncStep = ((GetSingleFullMusicInfoTask)paramAsyncStep).a;
        }
        else
        {
          if (TextUtils.isEmpty(localFlowMusic.songMid)) {
            localFlowMusic.songMid = ((GetSingleFullMusicInfoTask)paramAsyncStep).a.songMid;
          }
          localFlowMusic.storeTimeStamp = ((GetSingleFullMusicInfoTask)paramAsyncStep).a.storeTimeStamp;
          localFlowMusic.sourceType = 1;
          paramAsyncStep = localFlowMusic;
        }
        this.i.add(paramAsyncStep);
      }
      paramInt = this.a - 1;
      this.a = paramInt;
      if (paramInt == 0)
      {
        c();
        setResult(7);
        this.b = null;
      }
      this.mAutomator.a(this.b);
      return;
    }
    finally {}
  }
  
  protected int doStep()
  {
    this.a = this.j.size();
    if (!this.j.isEmpty())
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (FlowMusic)localIterator.next();
        if (this.mResult == 8) {
          break;
        }
        localObject = new GetSingleFullMusicInfoTask((FlowMusic)localObject, null);
        ((AsyncStep)localObject).mResultListener = this;
        this.mAutomator.b((AsyncStep)localObject);
      }
      return 2;
    }
    c();
    return 7;
  }
  
  public void onCreate()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.control.GetAllFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */