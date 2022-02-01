package com.tencent.hippy.qq.module;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import beqn;
import bfuc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@HippyNativeModule(name="QQTroopNoticeModule")
public class QQTroopNoticeModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQTroopNoticeModule";
  private BroadcastReceiver mCallReceiver;
  
  public QQTroopNoticeModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="showPicture")
  public void showPicture(String paramString, Promise paramPromise)
  {
    Object localObject1 = getFragment();
    if (localObject1 == null) {
      QLog.e("QQTroopNoticeModule", 1, "showPicture fragment is null");
    }
    for (;;)
    {
      return;
      localObject1 = ((Fragment)localObject1).getActivity();
      if (!(localObject1 instanceof BaseActivity))
      {
        QLog.e("QQTroopNoticeModule", 1, "showPicture activity isvnot BaseActivity");
        return;
      }
      BaseActivity localBaseActivity = (BaseActivity)localObject1;
      try
      {
        Object localObject5 = new JSONObject(paramString);
        Object localObject7 = ((JSONObject)localObject5).optString("bigurl");
        int i;
        int j;
        Object localObject4;
        Object localObject8;
        if (!TextUtils.isEmpty((CharSequence)localObject7))
        {
          paramString = ((JSONObject)localObject5).optString("videoID");
          localObject1 = ((JSONObject)localObject5).optString("videoURL");
          ((JSONObject)localObject5).optString("originalVideoURL");
          i = ((JSONObject)localObject5).optInt("videoWidth");
          j = ((JSONObject)localObject5).optInt("videoHeight");
          ((JSONObject)localObject5).optBoolean("isLike");
          localObject2 = QZoneHelper.UserInfo.getInstance();
          localObject3 = new Bundle();
          localObject4 = new ArrayList();
          localObject6 = new PhotoInfo();
          ((PhotoInfo)localObject6).bigUrl = ((String)localObject7);
          ((PhotoInfo)localObject6).videoflag = 1;
          ((PhotoInfo)localObject6).videodata = new VideoInfo();
          ((PhotoInfo)localObject6).videodata.videoId = paramString;
          localObject8 = new PictureUrl();
          ((PictureUrl)localObject8).url = ((String)localObject7);
          ((PhotoInfo)localObject6).videodata.coverUrl = ((PictureUrl)localObject8);
          localObject7 = new VideoUrl();
          ((VideoUrl)localObject7).url = ((String)localObject1);
          ((PhotoInfo)localObject6).videodata.videoId = paramString;
          ((PhotoInfo)localObject6).videodata.actionUrl = ((String)localObject1);
          ((PhotoInfo)localObject6).videodata.videoUrl = ((VideoUrl)localObject7);
          ((PhotoInfo)localObject6).videodata.width = i;
          ((PhotoInfo)localObject6).videodata.height = j;
          ((PhotoInfo)localObject6).videodata.videoStatus = 5;
          ((ArrayList)localObject4).add(localObject6);
          ((Bundle)localObject3).putSerializable("picturelist", (Serializable)localObject4);
          ((Bundle)localObject3).putInt("curindex", 0);
          ((Bundle)localObject3).putInt("mode", 3);
          ((Bundle)localObject3).putBoolean("need_clear_cache", true);
          QZoneHelper.forwardToPictureViewer(localBaseActivity, (QZoneHelper.UserInfo)localObject2, (Bundle)localObject3, 6);
        }
        Object localObject2 = ((JSONObject)localObject5).optJSONArray("imageIDs");
        localObject7 = ((JSONObject)localObject5).optJSONArray("likes");
        Object localObject6 = ((JSONObject)localObject5).optJSONArray("descs");
        Object localObject3 = ((JSONObject)localObject5).optJSONArray("sourceIDs");
        Object localObject9 = ((JSONObject)localObject5).optJSONArray("sourceSize");
        boolean bool1 = ((JSONObject)localObject5).optBoolean("needBottomBar");
        paramString = ((JSONObject)localObject5).optJSONObject("extra");
        if (paramString == null) {}
        boolean bool2;
        ArrayList localArrayList;
        int k;
        for (paramString = "";; paramString = paramString.toString())
        {
          j = ((JSONObject)localObject5).optInt("index");
          localObject8 = ((JSONObject)localObject5).optString("srcID");
          bool2 = ((JSONObject)localObject5).optBoolean("isReport");
          localObject1 = null;
          if (Boolean.valueOf(bool2).booleanValue())
          {
            localObject1 = new PublicAccountShowPictureReport();
            ((PublicAccountShowPictureReport)localObject1).parse((JSONObject)localObject5);
          }
          bool2 = ((JSONObject)localObject5).optBoolean("isNotShowIndex", true);
          if ((localObject2 == null) || (((JSONArray)localObject2).length() == 0) || (localBaseActivity.getAppInterface() == null)) {
            break;
          }
          localArrayList = new ArrayList();
          i = 0;
          k = ((JSONArray)localObject2).length();
          while (i < k)
          {
            localArrayList.add(((JSONArray)localObject2).get(i).toString());
            i += 1;
          }
        }
        if (localObject3 != null)
        {
          localObject2 = new ArrayList();
          i = 0;
          k = ((JSONArray)localObject3).length();
          while (i < k)
          {
            ((ArrayList)localObject2).add(((JSONArray)localObject3).get(i).toString());
            i += 1;
          }
        }
        for (;;)
        {
          localObject3 = null;
          if (localObject9 != null)
          {
            localObject4 = new ArrayList();
            i = 0;
            k = ((JSONArray)localObject9).length();
            for (;;)
            {
              localObject3 = localObject4;
              if (i >= k) {
                break;
              }
              ((ArrayList)localObject4).add(((JSONArray)localObject9).get(i).toString());
              i += 1;
            }
          }
          boolean bool3 = ((JSONObject)localObject5).optBoolean("showTitle", false);
          localObject4 = bfuc.encodeToString(((JSONObject)localObject5).optString("title", "").getBytes(), 0);
          localObject5 = ((JSONObject)localObject5).optString("articleUrl", "");
          if (QLog.isColorLevel()) {
            QLog.d("QQTroopNoticeModule", 2, new Object[] { "KANDIAN Grid Image title: ", localObject4, ", articleUrl: ", localObject5, ", showTitle: ", Boolean.valueOf(bool3) });
          }
          if (bool1)
          {
            if (localObject7 == null) {
              break;
            }
            localObject9 = new boolean[((JSONArray)localObject7).length()];
            i = 0;
            while (i < ((JSONArray)localObject7).length())
            {
              localObject9[i] = ((JSONArray)localObject7).getBoolean(i);
              i += 1;
            }
            localObject7 = new ArrayList();
            if ((localObject6 != null) && (((JSONArray)localObject6).length() != 0))
            {
              i = 0;
              k = ((JSONArray)localObject6).length();
              while (i < k)
              {
                ((ArrayList)localObject7).add(((JSONArray)localObject6).get(i).toString());
                i += 1;
              }
            }
            if (this.mCallReceiver == null)
            {
              this.mCallReceiver = new QQTroopNoticeModule.1(this, paramPromise);
              paramPromise = new IntentFilter("android.intent.action.WEBJSCALL");
              localBaseActivity.registerReceiver(this.mCallReceiver, paramPromise);
            }
            if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
            {
              beqn.a(localBaseActivity, j, localArrayList, (boolean[])localObject9, (ArrayList)localObject7, bool1, bool2, (String)localObject8, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject5, (String)localObject4, null, paramString);
              return;
            }
            beqn.a(localBaseActivity, j, localArrayList, (boolean[])localObject9, (ArrayList)localObject7, bool1, bool2, (String)localObject8, 100, (PublicAccountShowPictureReport)localObject1, null, (ArrayList)localObject2, (ArrayList)localObject3, paramString, true);
            return;
          }
          if ((bool3) && (!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
          {
            beqn.a(localBaseActivity, j, localArrayList, null, null, false, bool2, (String)localObject8, 100, (PublicAccountShowPictureReport)localObject1, (String)localObject5, (String)localObject4, null, paramString);
            return;
          }
          beqn.a(localBaseActivity, j, localArrayList, null, null, false, bool2, (String)localObject8, 100, (PublicAccountShowPictureReport)localObject1, null, paramString);
          return;
          localObject2 = null;
        }
        return;
      }
      catch (JSONException paramString) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQTroopNoticeModule
 * JD-Core Version:    0.7.0.1
 */