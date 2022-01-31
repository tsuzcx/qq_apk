import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public final class arko
  implements DialogInterface.OnClickListener, Handler.Callback, View.OnClickListener
{
  private final View jdField_a_of_type_AndroidViewView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private volatile aqxe jdField_a_of_type_Aqxe;
  private final arkl jdField_a_of_type_Arkl;
  private bdfq jdField_a_of_type_Bdfq;
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
  
  public arko(arkl paramarkl, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Arkl = paramarkl;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131372280);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372279));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131372273);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131372275);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372274));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372276));
    paramView.findViewById(2131372277).setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131369486);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369499));
    paramView.findViewById(2131369488).setOnClickListener(this);
    paramView.findViewById(2131369497).setOnClickListener(this);
    this.jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this, true);
    this.jdField_b_of_type_MqqOsMqqHandler = new bhoe(ThreadManagerV2.getFileThreadLooper(), this, false);
    this.jdField_c_of_type_MqqOsMqqHandler = new bhoe(ThreadManagerV2.getSubThreadLooper(), this, false);
    a();
  }
  
  private String a()
  {
    String str = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = this.jdField_d_of_type_AndroidWidgetTextView.getTag();
      if (((localObject instanceof String)) && (!TextUtils.isEmpty((String)localObject))) {
        return str + " " + BaseApplicationImpl.sApplication.getString(2131698527) + ":" + localObject;
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
    if (bkev.b(paramInt))
    {
      e();
      return;
    }
    if (paramInt == 2) {
      paramString = BaseApplicationImpl.sApplication.getResources().getString(2131694766);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      arkn.a(1, paramString, true);
      return;
    }
    paramString = BaseApplicationImpl.sApplication.getResources();
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 2131698511;; i = 2131698512)
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
      this.jdField_a_of_type_Arkl.a(paramBitmap, paramInt, paramString);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
    }
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_Arkl.a().getAppInterface();
    if ((localAppInterface instanceof QQAppInterface))
    {
      Message localMessage = new Message();
      localMessage.what = 9;
      localMessage.obj = new Object[] { (QQAppInterface)localAppInterface, paramFileManagerEntity, this.jdField_a_of_type_Arkl.a(), Boolean.valueOf(this.jdField_a_of_type_Boolean), paramString };
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
    localObject = this.jdField_a_of_type_Arkl.a().getAppInterface();
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698508);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTag(paramString2);
      bool = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
    } while (!bool);
    this.jdField_a_of_type_Arkl.b();
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
    if (bdee.d(BaseApplicationImpl.sApplication))
    {
      paramArrayOfObject = localQQAppInterface.a().a().a(paramArrayOfObject, null, new arkr(this, paramArrayOfObject, null));
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
      this.jdField_a_of_type_Aqxe = paramArrayOfObject;
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
    this.jdField_a_of_type_Aqxe = null;
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
    for (int i = 2131698503;; i = 2131698505)
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
    bdfq localbdfq;
    if (this.jdField_a_of_type_Bdfq == null)
    {
      this.jdField_a_of_type_Bdfq = new bdfq(this.jdField_a_of_type_Arkl.a(), 2131755801);
      this.jdField_a_of_type_Bdfq.setContentView(2131558943);
      this.jdField_a_of_type_Bdfq.setTitle(2131698513);
      localbdfq = this.jdField_a_of_type_Bdfq;
      if (!this.jdField_a_of_type_Boolean) {
        break label130;
      }
    }
    label130:
    for (int i = 2131698515;; i = 2131698514)
    {
      localbdfq.setMessage(i);
      this.jdField_a_of_type_Bdfq.setNegativeButton(2131690648, this);
      this.jdField_a_of_type_Bdfq.setPositiveButton(2131698516, this);
      this.jdField_a_of_type_Bdfq.setCancelable(true);
      this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
      if (!this.jdField_a_of_type_Bdfq.isShowing()) {
        this.jdField_a_of_type_Bdfq.show();
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
    Object localObject2 = (arkm)paramArrayOfObject[2];
    boolean bool1 = ((Boolean)paramArrayOfObject[3]).booleanValue();
    paramArrayOfObject = (String)paramArrayOfObject[4];
    if (bdee.d(BaseApplicationImpl.sApplication))
    {
      long l = arkn.a(((arkm)localObject2).jdField_a_of_type_Int);
      if (arof.b(paramArrayOfObject))
      {
        aqwl localaqwl = ((QQAppInterface)localObject1).a().a();
        if (!((arkm)localObject2).jdField_a_of_type_Boolean) {
          break label222;
        }
        localObject1 = ((arkm)localObject2).jdField_a_of_type_JavaLangString;
        label113:
        boolean bool2 = ((arkm)localObject2).jdField_b_of_type_Boolean;
        i = ((arkm)localObject2).jdField_a_of_type_Int;
        if (!((arkm)localObject2).jdField_a_of_type_Boolean) {
          break label228;
        }
        localObject2 = ((arkm)localObject2).jdField_a_of_type_JavaLangString;
        label141:
        localaqwl.a(localFileManagerEntity, l, (String)localObject1, bool2, bool1, new arkq(this, i, (String)localObject2, paramArrayOfObject, bool1, null));
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Arkl.a();
    String str2 = this.jdField_a_of_type_Arkl.b();
    if ((localFileManagerEntity == null) && (TextUtils.isEmpty(str2))) {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "startProcess: fileEntity and filePath are invalid");
    }
    while (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Arkl.b();
    Object localObject = this.jdField_a_of_type_Arkl.a();
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = "0X800A9D7";
      String str3 = arkn.b(((arkm)localObject).jdField_a_of_type_Int);
      if (!this.jdField_a_of_type_Boolean) {
        break label138;
      }
      localObject = null;
      label104:
      arkn.a(str1, str3, (String)localObject);
      if (!arkn.a(localFileManagerEntity, false)) {
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
      localObject = arkn.a(((arkm)localObject).jdField_a_of_type_Boolean);
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
      arkn.a("0X800A9D8", null, null);
      ((ClipboardManager)BaseApplicationImpl.sApplication.getSystemService("clipboard")).setText(str);
      arkn.a(2, 2131698501, true);
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
      paramArrayOfObject = arkn.a((String)localObject, bdkf.a(184.0F));
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
      arkn.a("0X800A9D9", null, null);
      this.jdField_a_of_type_Arkl.a(null);
    }
  }
  
  private void h(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleQrRelay: args are invalid");
    }
    a((Bitmap)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem> a(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131698506;
      localTextView.setText(i);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!this.jdField_a_of_type_Boolean) {
        break label147;
      }
    }
    label147:
    for (int i = 2131698502;; i = 2131698504)
    {
      localTextView.setText(i);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      this.jdField_d_of_type_AndroidWidgetTextView.setTag(null);
      boolean bool = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
      if (bool) {
        this.jdField_a_of_type_Arkl.b();
      }
      this.jdField_a_of_type_JavaLangString = null;
      return;
      i = 2131698507;
      break;
    }
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    int i = 1;
    if (paramActionSheetItem == null) {}
    int j;
    Object localObject1;
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            j = paramActionSheetItem.action;
            localObject1 = this.jdField_a_of_type_Arkl.a();
          } while ((localObject1 == null) || (((BaseActivity)localObject1).isFinishing()));
          if (bdee.d((Context)localObject1)) {
            break;
          }
          arkn.a(0, 2131692397, false);
        } while (!QLog.isColorLevel());
        QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "toShare: net is not supported");
        return;
      } while ((j != 2) && (j != 3) && (j != 9) && (j != 10) && (j != 72));
      str = a();
    } while (TextUtils.isEmpty(str));
    switch (j)
    {
    default: 
      return;
    case 2: 
      paramActionSheetItem = new Intent();
      paramActionSheetItem.putExtra("isFromShare", true);
      paramActionSheetItem.putExtra("forward_type", -1);
      paramActionSheetItem.putExtra("forward_text", str);
      arum.a((Activity)localObject1, paramActionSheetItem, 1, -1);
      return;
    case 3: 
      paramActionSheetItem = bizt.a();
      localObject2 = ((BaseActivity)localObject1).getAppInterface();
      paramActionSheetItem.jdField_a_of_type_JavaLangString = ((AppInterface)localObject2).getAccount();
      paramActionSheetItem.b = ((AppInterface)localObject2).getDisplayName(0, ((AppInterface)localObject2).getCurrentAccountUin(), null);
      bizm.a((Activity)localObject1, paramActionSheetItem, "", ((BaseActivity)localObject1).getString(2131692302), str, 2);
      return;
    case 9: 
    case 10: 
      paramActionSheetItem = this.jdField_a_of_type_Arkl.c();
      localObject1 = WXShareHelper.a();
      if (j == 9) {
        i = 0;
      }
      ((WXShareHelper)localObject1).a(str, i, paramActionSheetItem);
      return;
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_req", ForwardRecentActivity.f);
    ((Bundle)localObject2).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    ((Bundle)localObject2).putString("key_direct_show_uin", paramActionSheetItem.uin);
    paramActionSheetItem = new Intent();
    paramActionSheetItem.putExtra("isFromShare", true);
    paramActionSheetItem.putExtra("forward_type", -1);
    paramActionSheetItem.putExtra("forward_text", str);
    paramActionSheetItem.putExtras((Bundle)localObject2);
    arum.a((Activity)localObject1, paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, -1, "");
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem> b(Context paramContext)
  {
    return new ArrayList();
  }
  
  public void b()
  {
    aqxe localaqxe = this.jdField_a_of_type_Aqxe;
    this.jdField_a_of_type_Aqxe = null;
    if (localaqxe != null) {
      localaqxe.a();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Aqxe != null;
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_Bdfq != null)
    {
      this.jdField_a_of_type_Bdfq.dismiss();
      this.jdField_a_of_type_Bdfq = null;
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
    if (paramDialogInterface.equals(this.jdField_a_of_type_Bdfq)) {}
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    BaseActivity localBaseActivity = this.jdField_a_of_type_Arkl.a();
    if (this.jdField_a_of_type_Boolean) {}
    for (paramDialogInterface = "an_qq_qrcode_overcapacity";; paramDialogInterface = "an_qq_link_overcapacity")
    {
      bkif.a(localBaseActivity, paramDialogInterface, false);
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131372277: 
      f();
      return;
    case 2131369488: 
      g();
      return;
    }
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arko
 * JD-Core Version:    0.7.0.1
 */