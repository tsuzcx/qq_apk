import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.SpannableString;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation.9;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.UUID;

public class azpv
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public azpv(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  private int a()
  {
    return a(true);
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return bakx.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private static String b(int paramInt)
  {
    return BaseApplicationImpl.getContext().getResources().getString(paramInt);
  }
  
  private static String b(int paramInt, Object... paramVarArgs)
  {
    return String.format(b(paramInt), paramVarArgs);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramFileManagerEntity);
  }
  
  public int a(azpi paramazpi)
  {
    if ("/".equals(paramazpi.f)) {
      return 0;
    }
    return 1;
  }
  
  public azqv a(azpi paramazpi)
  {
    azqv localazqv2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramazpi.b);
    azqv localazqv1 = localazqv2;
    if (localazqv2 == null)
    {
      localazqv1 = bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramazpi.jdField_a_of_type_JavaUtilUUID.toString(), paramazpi.b, paramazpi.jdField_c_of_type_JavaLangString, paramazpi.jdField_a_of_type_Long, paramazpi.jdField_a_of_type_Int);
      localazqv1.jdField_c_of_type_JavaLangString = paramazpi.j;
      localazqv1.d = paramazpi.k;
      localazqv1.b = paramazpi.i;
    }
    if ((localazqv1 != null) && (localazqv1.jdField_c_of_type_Long == 0L)) {
      localazqv1.jdField_c_of_type_Long = paramazpi.jdField_a_of_type_Long;
    }
    return localazqv1;
  }
  
  public void a(azpi paramazpi)
  {
    paramazpi = new azqh(this, paramazpi);
    bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697544), b(2131697543), 2131690596, 2131694794, paramazpi, paramazpi).show();
  }
  
  public void a(azpi paramazpi, String paramString1, String paramString2)
  {
    bbgu localbbgu = bbdj.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbbgu.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localbbgu.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localbbgu.getMessageTextView().setLayoutParams(paramString1);
    localbbgu.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694794), new azqc(this, paramazpi));
    localbbgu.show();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new azqf(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131697647, new Object[] { bakx.a(paramFileManagerEntity.fileName), bakx.a(paramFileManagerEntity.fileSize) });
      localObject = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697860), paramFileManagerEntity, 2131690596, 2131719555, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = aseg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((bbgu)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((bbgu)localObject).show();
      return;
    }
    b(paramFileManagerEntity);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (a() == 0) {}
    TroopFileTransferManager localTroopFileTransferManager;
    do
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
      Object localObject = bahy.a(paramString2);
      localObject = ((aoww)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a((String)localObject);
      if ((!apug.a()) || (paramLong <= ((amxv)localObject).b)) {
        break;
      }
    } while (!bcwb.a(this.jdField_a_of_type_AndroidAppActivity, 1, new azqd(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new azqe(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131697648, new Object[] { bakx.a(paramString2), bakx.a(paramLong) });
    paramString1 = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697860), paramString2, 2131690596, 2131697584, paramString1, paramString1);
    paramString2 = aseg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
    if ((paramString2 instanceof SpannableString)) {
      paramString1.setMessageWithoutAutoLink(paramString2);
    }
    paramString1.show();
    return;
    localTroopFileTransferManager.a(paramString1, paramString2, paramLong, paramInt);
  }
  
  public void a(UUID paramUUID)
  {
    if (a() == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (apug.a())
    {
      azpw localazpw = new azpw(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131697652, new Object[] { bakx.a(paramUUID.g), bakx.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131697651))
      {
        bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697860), paramUUID, 2131690596, 2131697952, localazpw, localazpw).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(azpi paramazpi)
  {
    paramazpi = new azqi(this, paramazpi);
    bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697540), b(2131697539), 2131690596, 2131694794, paramazpi, paramazpi).show();
  }
  
  public void b(UUID paramUUID)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (i == 1)
    {
      azqv localazqv = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject;
      if (localazqv != null)
      {
        l = localazqv.jdField_c_of_type_Long;
        localObject = b(2131697650, new Object[] { bakx.a(localazqv.g), bakx.a(localazqv.jdField_c_of_type_Long) });
      }
      while (l > ((aoww)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bahy.a(localazqv.g)).b)
      {
        paramUUID = new azqg(this, localTroopFileTransferManager, paramUUID);
        paramUUID = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697860), (String)localObject, 2131690596, 2131697948, paramUUID, paramUUID);
        localObject = aseg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
        localObject = b(2131697649);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(azpi paramazpi)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new azpx(this, localTroopFileTransferManager, paramazpi), false);
  }
  
  public void d(azpi paramazpi)
  {
    int i = a(false);
    Object localObject = new azpz(this, paramazpi);
    if (i == 1) {}
    for (paramazpi = b(2131697650, new Object[] { bakx.a(paramazpi.jdField_c_of_type_JavaLangString), paramazpi.a() });; paramazpi = b(2131697950, new Object[] { bakx.a(paramazpi.jdField_c_of_type_JavaLangString) }))
    {
      localObject = bbdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697949), paramazpi, 2131690596, 2131697948, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        paramazpi = aseg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramazpi);
        if ((paramazpi instanceof SpannableString)) {
          ((bbgu)localObject).setMessageWithoutAutoLink(paramazpi);
        }
      }
      ((bbgu)localObject).show();
      return;
    }
  }
  
  public void e(azpi paramazpi)
  {
    boolean bool2 = false;
    bfpc localbfpc = (bfpc)bfpp.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968667);
    boolean bool1 = bool2;
    if (paramazpi.e == 11)
    {
      bool1 = bool2;
      if (apvd.b(paramazpi.h))
      {
        localbfpc.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramazpi.b()))) {
      localbfpc.a(arrayOfString[1], 1);
    }
    localbfpc.a(new azqa(this, bool1, paramazpi, localbfpc));
    localbfpc.c(2131690596);
    localbfpc.show();
  }
  
  public void f(azpi paramazpi)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131697594);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131697581), new Object[] { bakx.a(paramazpi.jdField_c_of_type_JavaLangString) });
    bbgu localbbgu = bbdj.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbbgu.setTitle(str1).setMessage(str2);
    localbbgu.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694794), new azqb(this, paramazpi));
    localbbgu.show();
  }
  
  public void g(azpi paramazpi)
  {
    if (a() != 0)
    {
      bajy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramazpi);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azpv
 * JD-Core Version:    0.7.0.1
 */