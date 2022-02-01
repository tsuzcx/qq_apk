package com.tencent.av.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SensorHelper;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

class MultiVideoCtrlLayerUI4NewGroupChat$6
  extends GAudioUIObserver
{
  MultiVideoCtrlLayerUI4NewGroupChat$6(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  protected void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (MultiVideoCtrlLayerUI4NewGroupChat.a(this.a))
    {
      this.a.r();
      if (paramInt == 0)
      {
        this.a.f(0L, null);
        return;
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        paramArrayOfByte = new String(paramArrayOfByte);
        String str = this.a.a().getString(2131720247);
        DialogUtil.a(this.a.a(), 230, null, paramArrayOfByte, null, str, new MultiVideoCtrlLayerUI4NewGroupChat.6.2(this), null).show();
      }
    }
    else
    {
      paramArrayOfByte = this.a.a().getResources().getString(2131695689);
      QQToast.a(this.a.a(), -1, paramArrayOfByte, 0).a();
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (this.a.h()) {
      return;
    }
    if (paramLong2 != this.a.b)
    {
      localObject1 = this.a.jdField_d_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreateRoomSuc, not right session. [");
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append(",");
      ((StringBuilder)localObject2).append(this.a.b);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    Object localObject1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    Object localObject2 = this.a.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreateRoomSuc, GroupID[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("], sessionId[");
    localStringBuilder.append(((SessionInfo)localObject1).b);
    localStringBuilder.append("]");
    QLog.w((String)localObject2, 1, localStringBuilder.toString());
    boolean bool = this.a.jdField_e_of_type_Boolean;
    int j = 3;
    if (bool) {
      i = 4;
    } else {
      i = 3;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_ComTencentAvVideoController.d());
    ((StringBuilder)localObject2).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject2).toString());
    int i = j;
    if (this.a.jdField_e_of_type_Boolean) {
      i = 4;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_ComTencentAvVideoController.d());
    ((StringBuilder)localObject2).append("");
    MultiVideoRichActionReportCollection.a(i, ((StringBuilder)localObject2).toString());
    this.a.z();
    this.a.q(paramLong1);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
    ((SessionInfo)localObject1).ab = true;
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.b);
    if (((SessionInfo)localObject1).W == 4)
    {
      localObject1 = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 != null) && (!((AVActivity)localObject1).isFinishing())) {
        ((AVActivity)localObject1).runOnUiThread(new MultiVideoCtrlLayerUI4NewGroupChat.6.1(this, paramLong1));
      }
    }
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString)
  {
    super.a(paramLong1, paramLong2, paramString);
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGroupSecurityLimit-->groupid=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" info=");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" strMsg=");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (this.a.jdField_e_of_type_Int != 1) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("tencent.av.v2q.MultiVideo");
    ((Intent)localObject).putExtra("type", 33);
    ((Intent)localObject).putExtra("relationId", paramLong1);
    ((Intent)localObject).putExtra("uinType", this.a.jdField_d_of_type_Int);
    ((Intent)localObject).putExtra("info", paramLong2);
    ((Intent)localObject).putExtra("strMsg", paramString);
    ((Intent)localObject).putExtra("from", "MultiVideoCtrlLayerUI4NewGroupChat1");
    paramString = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null)
    {
      ((Intent)localObject).setPackage(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
      paramString.sendBroadcast((Intent)localObject);
      MultiVideoCtrlLayerUI4NewGroupChat.b(this.a, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_d_of_type_JavaLangString, 2, "onGroupSecurityLimit-->can not get the activity");
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    this.a.i(0L, 16777215);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    this.a.b(paramLong, paramInt1, paramInt2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (this.a.h()) {
      return;
    }
    Object localObject = this.a.jdField_d_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoomSuc, GroupID[");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    boolean bool = this.a.jdField_e_of_type_Boolean;
    int j = 4;
    int i;
    if (bool) {
      i = 4;
    } else {
      i = 3;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvVideoController.d());
    ((StringBuilder)localObject).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject).toString());
    if (this.a.jdField_e_of_type_Boolean) {
      i = j;
    } else {
      i = 3;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvVideoController.d());
    ((StringBuilder)localObject).append("");
    MultiVideoRichActionReportCollection.a(i, ((StringBuilder)localObject).toString());
    this.a.z();
    this.a.q(paramLong1);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable(this.a), 500L);
    MultiVideoCtrlLayerUI4NewGroupChat.b(this.a);
    this.a.i(paramLong1, 16777215);
    this.a.E();
  }
  
  protected void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.b(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().S = true;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.d(this.a);
    }
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    super.c(paramLong1, paramLong2, paramBoolean);
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().S = false;
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Int == 10) {
      MultiVideoCtrlLayerUI4NewGroupChat.c(this.a);
    }
    if (this.a.jdField_a_of_type_ComTencentAvVideoController.a().jdField_j_of_type_Boolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.6
 * JD-Core Version:    0.7.0.1
 */