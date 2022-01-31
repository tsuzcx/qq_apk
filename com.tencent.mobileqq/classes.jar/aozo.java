import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public final class aozo
  implements DialogInterface.OnClickListener, Handler.Callback, View.OnClickListener
{
  private final View jdField_a_of_type_AndroidViewView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private volatile aonh jdField_a_of_type_Aonh;
  private final aozl jdField_a_of_type_Aozl;
  private bafb jdField_a_of_type_Bafb;
  private volatile FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private volatile String jdField_a_of_type_JavaLangString;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private final boolean jdField_a_of_type_Boolean;
  private final View jdField_b_of_type_AndroidViewView;
  private final TextView jdField_b_of_type_AndroidWidgetTextView;
  private final MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_b_of_type_Boolean;
  private final View jdField_c_of_type_AndroidViewView;
  private final TextView jdField_c_of_type_AndroidWidgetTextView;
  private final MqqHandler jdField_c_of_type_MqqOsMqqHandler;
  private volatile boolean jdField_c_of_type_Boolean;
  private final View jdField_d_of_type_AndroidViewView;
  private final TextView jdField_d_of_type_AndroidWidgetTextView;
  
  public aozo(aozl paramaozl, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Aozl = paramaozl;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131306266);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131306265));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131306259);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131306261);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131306260));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131306262));
    paramView.findViewById(2131306263).setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131303581);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131303594));
    paramView.findViewById(2131303583).setOnClickListener(this);
    paramView.findViewById(2131303592).setOnClickListener(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
    this.jdField_b_of_type_MqqOsMqqHandler = new beez(ThreadManagerV2.getFileThreadLooper(), this, false);
    this.jdField_c_of_type_MqqOsMqqHandler = new beez(ThreadManagerV2.getSubThreadLooper(), this, false);
    a();
  }
  
  private String a()
  {
    String str = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = this.jdField_d_of_type_AndroidWidgetTextView.getTag();
      if (((localObject instanceof String)) && (!TextUtils.isEmpty((String)localObject))) {
        return str + " " + BaseApplicationImpl.sApplication.getString(2131632495) + ":" + localObject;
      }
      return str;
    }
    return null;
  }
  
  private void a(float paramFloat)
  {
    int i = (int)Math.floor(100.0F * paramFloat);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(i + "%");
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void a(int paramInt, String paramString)
  {
    a();
    if (bgtg.b(paramInt))
    {
      e();
      return;
    }
    if (paramInt == 2) {
      paramString = BaseApplicationImpl.sApplication.getResources().getString(2131628948);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      aozn.a(1, paramString, true);
      return;
    }
    paramString = BaseApplicationImpl.sApplication.getResources();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131632479;; i = 2131632480)
    {
      paramString = paramString.getString(i, new Object[] { Integer.valueOf(paramInt) });
      break;
    }
  }
  
  private void a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if (paramBitmap == null) {
      a(-1, null);
    }
    for (;;)
    {
      a();
      return;
      this.jdField_a_of_type_Aozl.a(paramBitmap, paramInt, paramString);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
    }
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_Aozl.a().getAppInterface();
    if ((localAppInterface instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 9;
      localMessage.obj = new Object[] { (QQAppInterface)localAppInterface, paramFileManagerEntity, this.jdField_a_of_type_Aozl.a(), Boolean.valueOf(this.jdField_a_of_type_Boolean), paramString };
      this.jdField_c_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    throw new IllegalStateException("processCloudFile: need QQAppInterface, must run in main process.");
  }
  
  private void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject != null)
    {
      a((FileManagerEntity)localObject, null);
      return;
    }
    localObject = this.jdField_a_of_type_Aozl.a().getAppInterface();
    if ((localObject instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 8;
      localMessage.obj = new Object[] { (QQAppInterface)localObject, paramString };
      this.jdField_b_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    throw new IllegalStateException("processLocalFile: need QQAppInterface, must run in main process.");
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (this.jdField_a_of_type_Boolean)
    {
      Message localMessage = new Message();
      localMessage.what = 10;
      localMessage.obj = new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 };
      this.jdField_c_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
    boolean bool;
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131632476);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTag(paramString2);
      bool = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
    } while (!bool);
    this.jdField_a_of_type_Aozl.b();
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleError: args are invalid");
    }
    a(((Integer)paramArrayOfObject[0]).intValue(), (String)paramArrayOfObject[1]);
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleUpload: args are invalid");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    int i;
    if (badq.d(BaseApplicationImpl.sApplication))
    {
      paramArrayOfObject = localQQAppInterface.a().a().a(paramArrayOfObject, null, new aozr(this, paramArrayOfObject, null));
      if (paramArrayOfObject == null) {
        i = -3;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i), null };
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramArrayOfObject);
      }
      return;
      this.jdField_a_of_type_Aonh = paramArrayOfObject;
      i = 0;
      continue;
      i = 2;
    }
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      throw new IllegalArgumentException("handleUploadSucceed: args are invalid");
    }
    UploadJobContext.StatusInfo localStatusInfo = (UploadJobContext.StatusInfo)paramArrayOfObject[0];
    paramArrayOfObject = (String)paramArrayOfObject[1];
    if (QLog.isColorLevel()) {
      QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "upload is succeed, for file:" + paramArrayOfObject);
    }
    a(1.0F);
    this.jdField_a_of_type_Aonh = null;
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.WeiYunFileId = localStatusInfo.fileId;
    if (localStatusInfo.jobContext != null) {}
    for (paramArrayOfObject = localStatusInfo.jobContext.file().pDirKey;; paramArrayOfObject = null)
    {
      localFileManagerEntity.WeiYunDirKey = paramArrayOfObject;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = localFileManagerEntity;
      a(localFileManagerEntity, null);
      return;
    }
  }
  
  private void d()
  {
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    TextView localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131632471;; i = 2131632473)
    {
      localTextView.setText(i);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("");
      return;
    }
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 1)) {
      throw new IllegalArgumentException("handleUploadProgress: args are invalid");
    }
    a(((Float)paramArrayOfObject[0]).floatValue());
  }
  
  private void e()
  {
    bafb localbafb;
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = new bafb(this.jdField_a_of_type_Aozl.a(), 2131690181);
      this.jdField_a_of_type_Bafb.setContentView(2131493345);
      this.jdField_a_of_type_Bafb.setTitle(2131632481);
      localbafb = this.jdField_a_of_type_Bafb;
      if (!this.jdField_a_of_type_Boolean) {
        break label130;
      }
    }
    label130:
    for (int i = 2131632483;; i = 2131632482)
    {
      localbafb.setMessage(i);
      this.jdField_a_of_type_Bafb.setNegativeButton(2131625035, this);
      this.jdField_a_of_type_Bafb.setPositiveButton(2131632484, this);
      this.jdField_a_of_type_Bafb.setCancelable(true);
      this.jdField_a_of_type_Bafb.setCanceledOnTouchOutside(false);
      if (!this.jdField_a_of_type_Bafb.isShowing()) {
        this.jdField_a_of_type_Bafb.show();
      }
      return;
    }
  }
  
  private void e(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 5)) {
      throw new IllegalArgumentException("handleRequest: args are invalid");
    }
    Object localObject1 = (QQAppInterface)paramArrayOfObject[0];
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramArrayOfObject[1];
    Object localObject2 = (aozm)paramArrayOfObject[2];
    boolean bool1 = ((Boolean)paramArrayOfObject[3]).booleanValue();
    paramArrayOfObject = (String)paramArrayOfObject[4];
    if (badq.d(BaseApplicationImpl.sApplication))
    {
      long l = aozn.a(((aozm)localObject2).jdField_a_of_type_Int);
      if (apdh.b(paramArrayOfObject))
      {
        aomp localaomp = ((QQAppInterface)localObject1).a().a();
        if (!((aozm)localObject2).jdField_a_of_type_Boolean) {
          break label222;
        }
        localObject1 = ((aozm)localObject2).jdField_a_of_type_JavaLangString;
        label113:
        boolean bool2 = ((aozm)localObject2).jdField_b_of_type_Boolean;
        i = ((aozm)localObject2).jdField_a_of_type_Int;
        if (!((aozm)localObject2).jdField_a_of_type_Boolean) {
          break label228;
        }
        localObject2 = ((aozm)localObject2).jdField_a_of_type_JavaLangString;
        label141:
        localaomp.a(localFileManagerEntity, l, (String)localObject1, bool2, bool1, new aozq(this, i, (String)localObject2, paramArrayOfObject, bool1, null));
      }
    }
    for (int i = 0;; i = 2)
    {
      if (i != 0)
      {
        paramArrayOfObject = new Message();
        paramArrayOfObject.what = 1;
        paramArrayOfObject.obj = new Object[] { Integer.valueOf(i), null };
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramArrayOfObject);
      }
      return;
      paramArrayOfObject = null;
      break;
      label222:
      localObject1 = null;
      break label113;
      label228:
      localObject2 = null;
      break label141;
    }
  }
  
  private void f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aozl.a();
    String str2 = this.jdField_a_of_type_Aozl.b();
    if ((localFileManagerEntity == null) && (TextUtils.isEmpty(str2))) {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "startProcess: fileEntity and filePath are invalid");
    }
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Aozl.b();
    Object localObject = this.jdField_a_of_type_Aozl.a();
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = "0X800A9D7";
      String str3 = aozn.b(((aozm)localObject).jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label138;
      }
      localObject = null;
      label104:
      aozn.a(str1, str3, (String)localObject);
      if (!aozn.a(localFileManagerEntity, false)) {
        break label149;
      }
      a(localFileManagerEntity, str2);
    }
    for (;;)
    {
      d();
      return;
      str1 = "0X800A9D6";
      break;
      label138:
      localObject = aozn.a(((aozm)localObject).jdField_a_of_type_Boolean);
      break label104;
      label149:
      a(str2);
    }
  }
  
  private void f(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleRequestSucceed: args are invalid");
    }
    a((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void g()
  {
    String str = a();
    if (!TextUtils.isEmpty(str))
    {
      aozn.a("0X800A9D8", null, null);
      ((ClipboardManager)BaseApplicationImpl.sApplication.getSystemService("clipboard")).setText(str);
      aozn.a(2, 2131632469, true);
    }
  }
  
  private void g(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleGetQr: args are invalid");
    }
    Object localObject = (String)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    String str = (String)paramArrayOfObject[2];
    try
    {
      paramArrayOfObject = aozn.a((String)localObject, bajq.a(184.0F));
      localObject = new Message();
      ((Message)localObject).what = 7;
      ((Message)localObject).obj = new Object[] { paramArrayOfObject, Integer.valueOf(i), str };
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      return;
    }
    catch (Throwable paramArrayOfObject)
    {
      for (;;)
      {
        QLog.e("WeiyunShareProcessController<FileAssistant>", 2, "GetQrTask error", paramArrayOfObject);
        paramArrayOfObject = null;
      }
    }
  }
  
  private void h()
  {
    if (!TextUtils.isEmpty(a()))
    {
      aozn.a("0X800A9D9", null, null);
      this.jdField_a_of_type_Aozl.a(null);
    }
  }
  
  private void h(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleQrRelay: args are invalid");
    }
    a((Bitmap)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131632474;
      localTextView.setText(i);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!this.jdField_a_of_type_Boolean) {
        break label147;
      }
    }
    label147:
    for (int i = 2131632470;; i = 2131632472)
    {
      localTextView.setText(i);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      this.jdField_d_of_type_AndroidWidgetTextView.setTag(null);
      boolean bool = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
      if (bool) {
        this.jdField_a_of_type_Aozl.b();
      }
      this.jdField_a_of_type_JavaLangString = null;
      return;
      i = 2131632475;
      break;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = this.jdField_a_of_type_Aozl.a();
    if ((localObject1 == null) || (((BaseActivity)localObject1).isFinishing())) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (badq.d((Context)localObject1)) {
            break;
          }
          aozn.a(0, 2131626719, false);
        } while (!QLog.isColorLevel());
        QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "toShare: net is not supported");
        return;
      } while ((paramInt != 2) && (paramInt != 3) && (paramInt != 9) && (paramInt != 10));
      str = a();
    } while (TextUtils.isEmpty(str));
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return;
    case 2: 
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("isFromShare", true);
      ((Intent)localObject2).putExtra("forward_type", -1);
      ((Intent)localObject2).putExtra("forward_text", str);
      aphp.a((Activity)localObject1, (Intent)localObject2, 1, -1);
      return;
    case 3: 
      localObject2 = bfpy.a();
      AppInterface localAppInterface = ((BaseActivity)localObject1).getAppInterface();
      ((bfpy)localObject2).jdField_a_of_type_JavaLangString = localAppInterface.getAccount();
      ((bfpy)localObject2).jdField_b_of_type_JavaLangString = localAppInterface.getDisplayName(0, localAppInterface.getCurrentAccountUin(), null);
      bfpr.a((Activity)localObject1, (bfpy)localObject2, "", ((BaseActivity)localObject1).getString(2131626640), str, 2);
      return;
    }
    localObject1 = this.jdField_a_of_type_Aozl.c();
    Object localObject2 = WXShareHelper.a();
    if (paramInt == 9) {}
    for (paramInt = 0;; paramInt = 1)
    {
      ((WXShareHelper)localObject2).a(str, paramInt, (String)localObject1);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public List<bahx>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    bahx localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630983);
    localbahx.jdField_b_of_type_Int = 2130838732;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 2;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630996);
    localbahx.jdField_b_of_type_Int = 2130838733;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 3;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131631003);
    localbahx.jdField_b_of_type_Int = 2130838736;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 9;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    localbahx = new bahx();
    localbahx.jdField_a_of_type_JavaLangString = paramContext.getString(2131630986);
    localbahx.jdField_b_of_type_Int = 2130838730;
    localbahx.jdField_b_of_type_Boolean = true;
    localbahx.c = 10;
    localbahx.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localbahx);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    aonh localaonh = this.jdField_a_of_type_Aonh;
    this.jdField_a_of_type_Aonh = null;
    if (localaonh != null) {
      localaonh.a();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Aonh != null;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bafb != null)
    {
      this.jdField_a_of_type_Bafb.dismiss();
      this.jdField_a_of_type_Bafb = null;
    }
    b();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_c_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      a((Object[])paramMessage.obj);
      continue;
      c((Object[])paramMessage.obj);
      continue;
      d((Object[])paramMessage.obj);
      continue;
      f((Object[])paramMessage.obj);
      continue;
      h((Object[])paramMessage.obj);
      continue;
      b((Object[])paramMessage.obj);
      continue;
      e((Object[])paramMessage.obj);
      continue;
      g((Object[])paramMessage.obj);
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface.equals(this.jdField_a_of_type_Bafb)) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    BaseActivity localBaseActivity = this.jdField_a_of_type_Aozl.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (paramDialogInterface = "an_qq_qrcode_overcapacity";; paramDialogInterface = "an_qq_link_overcapacity")
    {
      bgwq.a(localBaseActivity, paramDialogInterface, false);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131306263: 
      f();
      return;
    case 2131303583: 
      g();
      return;
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aozo
 * JD-Core Version:    0.7.0.1
 */