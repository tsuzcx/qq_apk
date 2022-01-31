package com.tencent.mobileqq.apollo.process.chanel;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.sdk.AVContext;
import com.tencent.TMG.sdk.AVRoomMulti;
import com.tencent.TMG.sdk.AVVideoCtrl;
import com.tencent.TMG.sdk.AVVideoCtrl.EnableCameraCompleteCallback;
import com.tencent.TMG.sdk.AVView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.AVCameraCaptureModel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.IRequestHandler;
import com.tencent.mobileqq.apollo.aioChannel.HandleResult;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import ymz;
import yna;
import ynb;
import ynd;
import ynf;
import yng;
import ynh;
import ynj;
import ynk;
import ynl;
import ynm;
import ynn;
import yno;
import ynp;
import ynq;
import ynr;
import yns;
import ynt;

public class CmGameAvHandler
  implements ApolloCmdChannel.IRequestHandler
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private AVVideoCtrl.EnableCameraCompleteCallback jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$EnableCameraCompleteCallback = new ynj(this);
  public AVCameraCaptureModel a;
  public AVEngineEventHandler a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  private boolean e;
  
  public CmGameAvHandler(int paramInt)
  {
    this.jdField_a_of_type_ComTencentQqavopensdkAVEngineEventHandler = new ynh(this);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  private void a(String[] paramArrayOfString, String paramString)
  {
    int j = 0;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i].equals(paramString)) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList1.add(paramArrayOfString[i]);
        AVView localAVView = new AVView();
        localAVView.videoSrcType = 1;
        localAVView.viewSizeType = 1;
        localArrayList2.add(localAVView);
      }
    }
    if (QLog.isColorLevel())
    {
      i = 0;
      while (i < localArrayList1.size())
      {
        QLog.d("CmGameAvHandler", 2, "requestVideo identifiers=" + ((String)localArrayList1.get(i)).toString());
        i += 1;
      }
    }
    paramArrayOfString = new ynk(this);
    if (QLog.isColorLevel())
    {
      i = j;
      while (i < localArrayList1.size())
      {
        QLog.d("CmGameAvHandler", 2, "xxxx request iden=" + (String)localArrayList1.get(i));
        i += 1;
      }
    }
    if ((AVManager.a(BaseApplicationImpl.getContext()).a() != null) && (AVManager.a(BaseApplicationImpl.getContext()).a().getRoom() != null) && (localArrayList1.size() > 0)) {
      AVManager.a(BaseApplicationImpl.getContext()).a().getRoom().requestViewList((String[])localArrayList1.toArray(new String[localArrayList1.size()]), (AVView[])localArrayList2.toArray(new AVView[localArrayList2.size()]), localArrayList1.size(), paramArrayOfString);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (GraphicRendererMgr.getInstance() != null)) {}
    int i = 1;
    Object localObject = a();
    if (localObject != null) {
      i = ((AVVideoCtrl)localObject).enableCamera(0, paramBoolean, this.jdField_a_of_type_ComTencentTMGSdkAVVideoCtrl$EnableCameraCompleteCallback);
    }
    if (i == 0) {}
    for (;;)
    {
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("res", 0);
        CmGameUtil.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, "cs.audioRoom_camera_enable.local", ((JSONObject)localObject).toString());
        return;
      }
      catch (Exception localException2) {}
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("res", -1);
        CmGameUtil.a().callbackFromRequest(this.jdField_a_of_type_Long, i, "cs.audioRoom_camera_enable.local", ((JSONObject)localObject).toString());
        return;
      }
      catch (Exception localException1) {}
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  AVVideoCtrl a()
  {
    AVContext localAVContext = AVManager.a(BaseApplicationImpl.getContext()).a();
    if (localAVContext != null) {
      return localAVContext.getVideoCtrl();
    }
    return null;
  }
  
  public HandleResult a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    if ((!"cs.audioRoom_enter.local".equals(paramString1)) || (!TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString2);
        i = paramString1.optInt("avRoomId");
        paramLong = paramString1.optLong("gameRoomId");
        paramString1 = paramString1.optString("avRoleName", "lmxtest");
        ThreadManager.getUIHandler().post(new ymz(this, paramString1, paramLong, i));
        return null;
      }
      catch (Exception paramString1)
      {
        int i;
        return null;
      }
      if ("cs.audioRoom_exit.local".equals(paramString1))
      {
        ThreadManager.getUIHandler().post(new ynm(this));
        return null;
      }
      if ("cs.audioRoom_camera_enable.local".equals(paramString1)) {}
      try
      {
        bool = new JSONObject(paramString2).optBoolean("switch");
        this.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          ThreadManager.getUIHandler().post(new ynn(this));
          return null;
        }
        ThreadManager.getUIHandler().post(new yno(this));
        return null;
      }
      catch (Exception paramString1)
      {
        boolean bool;
        return null;
      }
      if ("cs.audioRoom_set_mic.local".equals(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        try
        {
          bool = new JSONObject(paramString2).optBoolean("switch");
          ThreadManager.getUIHandler().post(new ynp(this, bool));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_set_speaker.local".equals(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        try
        {
          bool = new JSONObject(paramString2).optBoolean("switch");
          ThreadManager.getUIHandler().post(new ynq(this, bool));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_init.local".equals(paramString1))
      {
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        try
        {
          a(paramString2);
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_set_local_video.local".equals(paramString1)) {}
      try
      {
        bool = new JSONObject(paramString2).optBoolean("switch");
        this.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          ThreadManager.getUIHandler().post(new ynr(this));
          return null;
        }
        ThreadManager.getUIHandler().post(new yns(this));
        return null;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      if ("cs.audioRoom_camera_switch.local".equals(paramString1)) {}
      try
      {
        i = new JSONObject(paramString2).optInt("cameraPos");
        if (!this.jdField_a_of_type_Boolean)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CmGameAvHandler", 2, "switch carmera but carma close");
          return null;
        }
        ThreadManager.getUIHandler().post(new ynt(this, i, paramLong));
        return null;
      }
      catch (Exception paramString1) {}
      if ("cs.audioRoom_change_qav_role.local".equals(paramString1)) {
        try
        {
          paramString1 = new JSONObject(paramString2).optString("role", "user");
          ThreadManager.getUIHandler().post(new yna(this, paramString1, paramLong));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_set_remote_video.local".equals(paramString1)) {
        try
        {
          paramString1 = Boolean.valueOf(new JSONObject(paramString2).optBoolean("switch"));
          this.d = paramString1.booleanValue();
          ThreadManager.getUIHandler().post(new ynb(this, paramString1));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
      if ("cs.audioRoom_watch_remote_video.local".equals(paramString1)) {
        try
        {
          paramString1 = new JSONObject(paramString2).optJSONArray("openIdList");
          if (paramString1 == null) {
            continue;
          }
          ThreadManager.getUIHandler().post(new ynd(this, paramString1));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      } else if ("cs.audioRoom_set_beauty.local".equals(paramString1)) {
        try
        {
          float f = (float)new JSONObject(paramString2).optDouble("beauty");
          ThreadManager.getUIHandler().post(new ynf(this, f));
          return null;
        }
        catch (Exception paramString1)
        {
          return null;
        }
      }
    }
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("sdkAppId"))
        {
          i = paramString.optInt("sdkAppId");
          if (paramString.has("accountType")) {
            j = paramString.optInt("accountType");
          }
          ThreadManager.getUIHandler().post(new yng(this, i, j));
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      int i = 0;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AVEngineWalper.a().c();
      if (this.e)
      {
        if (!paramBoolean) {
          break label120;
        }
        if (this.jdField_b_of_type_Boolean) {
          AVEngineWalper.a().a(paramBoolean);
        }
      }
      label35:
      if (this.e)
      {
        if (!paramBoolean) {
          break label130;
        }
        if (this.c) {
          AVEngineWalper.a().b(paramBoolean);
        }
      }
      label60:
      if (this.d)
      {
        if (!paramBoolean) {
          break label140;
        }
        a((String[])this.jdField_a_of_type_JavaUtilArrayList.toArray(new String[this.jdField_a_of_type_JavaUtilArrayList.size()]), "");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        b(paramBoolean);
      }
      label120:
      do
      {
        return;
        AVEngineWalper.a().b();
        break;
        AVEngineWalper.a().a(paramBoolean);
        break label35;
        AVEngineWalper.a().b(paramBoolean);
        break label60;
      } while ((AVManager.a(BaseApplicationImpl.getContext()).a() == null) || (AVManager.a(BaseApplicationImpl.getContext()).a().getRoom() == null));
      label130:
      label140:
      AVManager.a(BaseApplicationImpl.getContext()).a().getRoom().cancelAllView(new ynl(this));
    }
  }
  
  public boolean a(Activity paramActivity)
  {
    return false;
  }
  
  public void b()
  {
    a(false);
  }
  
  public void c()
  {
    a(true);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int != -1)
    {
      AVEngineWalper.a().a("" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloAVCameraCaptureModel != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloAVCameraCaptureModel.b();
      }
      b(false);
      this.jdField_a_of_type_Int = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler
 * JD-Core Version:    0.7.0.1
 */