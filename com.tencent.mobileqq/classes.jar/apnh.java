import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.MPFileFailedView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class apnh
  extends apmi
{
  private long jdField_a_of_type_Long;
  private akat jdField_a_of_type_Akat = new apnn(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  View jdField_a_of_type_AndroidViewView = null;
  bbin jdField_a_of_type_Bbin;
  private MPFileFailedView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView;
  private MPFileVerifyPwdView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int d;
  protected String f;
  
  public apnh(BaseActivity paramBaseActivity, List<apkt> paramList, int paramInt)
  {
    super(paramBaseActivity);
    if (QLog.isColorLevel()) {
      QLog.i("MPcFileModel<FileAssistant>", 1, "FileBrowserModel init: type = mpc");
    }
    a(paramList, paramInt);
  }
  
  private void a(long paramLong)
  {
    ajum localajum = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "MPFileDoDownloadWithBuildConnection mConnPCSuc false!");
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,connPcSessionId:" + paramLong + ",mEntity.uniseq:" + localFileManagerEntity.uniseq + ",mEntity.peerDin:" + localFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + localFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + localFileManagerEntity.fileName + ",mEntity.fileSize:" + localFileManagerEntity.fileSize);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_b_of_type_Boolean = true;
    paramLong = localajum.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramLong, this.jdField_c_of_type_Int);
    if (paramLong == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
      }
      aptx.a(2131693946);
      return;
    }
    localFileManagerEntity.uniseq = paramLong;
    localFileManagerEntity.status = 2;
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.c();
    }
    n();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = new MPFileFailedView(this.jdField_a_of_type_Apkq.getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.b();
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.a(this.jdField_a_of_type_Apkq.a(), new apnk(this), paramInt, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Apkq.a().setVisibility(0);
    this.jdField_a_of_type_Apkq.a().removeAllViews();
    this.jdField_a_of_type_Apkq.a().addView(this.jdField_a_of_type_AndroidViewView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  private void g(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      this.jdField_c_of_type_Int = 1;
      return;
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public int a()
  {
    int i = e();
    int j = super.a();
    if (j != 0) {
      return j;
    }
    switch (i)
    {
    default: 
      return 1;
    }
    return 6;
  }
  
  public amgv a()
  {
    String str = c();
    if (bbdx.b(str)) {
      return new aple(str);
    }
    return new aplc();
  }
  
  public apli a()
  {
    if (this.jdField_a_of_type_Apli == null) {
      this.jdField_a_of_type_Apli = new apno(this);
    }
    return this.jdField_a_of_type_Apli;
  }
  
  public aplk a()
  {
    return this.jdField_a_of_type_Aplk;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      i = new JSONObject(paramArrayOfByte).getInt("changePwd");
      if (i == 1)
      {
        aptx.b(2131694332);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.d();
        }
        return;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          int i = 0;
        }
        aptx.a(2131694331);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.d();
    }
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      this.f = new JSONObject(paramArrayOfByte).getString("nonce");
      if (paramBoolean) {
        this.d += 1;
      }
      if (this.d >= 3)
      {
        this.jdField_a_of_type_Bbin = new bbin(this.jdField_a_of_type_AndroidAppActivity, 2131755791);
        this.jdField_a_of_type_Bbin.setContentView(2131558908);
        this.jdField_a_of_type_Bbin.setTitle(2131694343);
        this.jdField_a_of_type_Bbin.a(2131694342);
        this.jdField_a_of_type_Bbin.a(0, 0, null);
        this.jdField_a_of_type_Bbin.a(2131693933, new apnm(this));
        this.jdField_a_of_type_Bbin.show();
      }
      if ((paramBoolean) && (this.d < 3)) {
        aptx.a(2131694385);
      }
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "RelayHttpMgrInfo roomno:" + this.f);
      if (this.jdField_a_of_type_Apkq != null) {
        this.jdField_a_of_type_Apkq.a(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null) {
        m();
      }
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public ArrayList<bbjs>[] a()
  {
    if (!apvd.a(c())) {
      return null;
    }
    return super.a();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new apni(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.addAction(bgpg.d);
      localIntentFilter.addAction(bgpg.g);
      localIntentFilter.setPriority(200);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new apnj(this);
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler != null) {
      AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  }
  
  public String f()
  {
    return "";
  }
  
  public int j()
  {
    int j = 2;
    int i = e();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        return 0;
      }
      if (bbdx.b(c())) {
        if ((this.jdField_a_of_type_Apkq != null) && (this.jdField_a_of_type_Apkq.d())) {
          i = j;
        }
      }
      for (;;)
      {
        return i;
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  protected void m()
  {
    o();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = new MPFileVerifyPwdView(this.jdField_a_of_type_Apkq.getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a(this.jdField_a_of_type_Apkq.a(), new apnl(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.b();
    this.jdField_a_of_type_Apkq.a().setVisibility(0);
    this.jdField_a_of_type_Apkq.a().removeAllViews();
    this.jdField_a_of_type_Apkq.a().addView(this.jdField_b_of_type_AndroidViewView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Apkq.a().removeView(this.jdField_b_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = null;
    }
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Apkq.a().removeView(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = null;
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_Boolean = true;
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE process_CS_SERVER_OK,mConnPCSuc:" + this.jdField_a_of_type_Boolean);
    this.d = 0;
    a(this.jdField_c_of_type_Long);
    Object localObject = (InputMethodManager)this.jdField_a_of_type_Apkq.a().getContext().getSystemService("input_method");
    boolean bool = ((InputMethodManager)localObject).isActive();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) && (bool))
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.getWindowToken(), 0);
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_Apkq.a().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.c();
    }
    localObject = this.jdField_a_of_type_Apkt.a();
    if (!this.jdField_a_of_type_Boolean)
    {
      ((FileManagerEntity)localObject).mContext = "needMPFileC2C";
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + this.jdField_a_of_type_Boolean + ",create mEntity.mContext");
    }
    for (;;)
    {
      n();
      o();
      this.jdField_a_of_type_Apkq.a().removeAllViews();
      this.jdField_a_of_type_Apkq.a();
      this.jdField_a_of_type_Apkq.e();
      return;
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + this.jdField_a_of_type_Boolean + "mEntity.mContext = null");
      ((FileManagerEntity)localObject).mContext = null;
    }
  }
  
  public void q()
  {
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc CS_RES_403CHECK!");
  }
  
  public void r()
  {
    this.jdField_a_of_type_Boolean = false;
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc disconnect!");
  }
  
  protected void s()
  {
    ajum localajum = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mConnPCSuc:" + this.jdField_a_of_type_Boolean);
    if (!this.jdField_a_of_type_Boolean) {
      if (localajum.a().a())
      {
        this.jdField_c_of_type_Long = localajum.a().a(1);
        QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "MPFile doDownload() mConnPCSuc false,mConnectPcSessionId:" + this.jdField_c_of_type_Long);
      }
    }
    label298:
    do
    {
      long l;
      do
      {
        return;
        this.jdField_c_of_type_Long = localajum.a().a(2);
        break;
        QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mEntity.uniseq:" + localFileManagerEntity.uniseq + ",mEntity.peerDin:" + localFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + localFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + localFileManagerEntity.fileName + ",mEntity.fileSize:" + localFileManagerEntity.fileSize);
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
        this.jdField_b_of_type_Boolean = true;
        l = localajum.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize);
        if (l != -1L) {
          break label298;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
        }
        aptx.a(2131693946);
      } while (this.jdField_a_of_type_Apnf == null);
      this.jdField_a_of_type_Apnf.g();
      return;
      localFileManagerEntity.uniseq = l;
      localFileManagerEntity.status = 2;
    } while (this.jdField_a_of_type_Apnf == null);
    this.jdField_a_of_type_Apnf.d();
  }
  
  protected void t()
  {
    this.jdField_b_of_type_Boolean = true;
    ajum localajum = (ajum)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apkt.a();
    localajum.a().a(localFileManagerEntity.strDataLineMPFileID);
    localFileManagerEntity.status = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apnh
 * JD-Core Version:    0.7.0.1
 */