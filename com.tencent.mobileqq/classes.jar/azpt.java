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

public class azpt
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public azpt(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      return bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return bakj.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public int a(azpg paramazpg)
  {
    if ("/".equals(paramazpg.f)) {
      return 0;
    }
    return 1;
  }
  
  public azqt a(azpg paramazpg)
  {
    azqt localazqt2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramazpg.b);
    azqt localazqt1 = localazqt2;
    if (localazqt2 == null)
    {
      localazqt1 = bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramazpg.jdField_a_of_type_JavaUtilUUID.toString(), paramazpg.b, paramazpg.jdField_c_of_type_JavaLangString, paramazpg.jdField_a_of_type_Long, paramazpg.jdField_a_of_type_Int);
      localazqt1.jdField_c_of_type_JavaLangString = paramazpg.j;
      localazqt1.d = paramazpg.k;
      localazqt1.b = paramazpg.i;
    }
    if ((localazqt1 != null) && (localazqt1.jdField_c_of_type_Long == 0L)) {
      localazqt1.jdField_c_of_type_Long = paramazpg.jdField_a_of_type_Long;
    }
    return localazqt1;
  }
  
  public void a(azpg paramazpg)
  {
    paramazpg = new azqf(this, paramazpg);
    bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697543), b(2131697542), 2131690596, 2131694793, paramazpg, paramazpg).show();
  }
  
  public void a(azpg paramazpg, String paramString1, String paramString2)
  {
    bbgg localbbgg = bbcv.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbbgg.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localbbgg.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localbbgg.getMessageTextView().setLayoutParams(paramString1);
    localbbgg.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694793), new azqa(this, paramazpg));
    localbbgg.show();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new azqd(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131697646, new Object[] { bakj.a(paramFileManagerEntity.fileName), bakj.a(paramFileManagerEntity.fileSize) });
      localObject = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697850), paramFileManagerEntity, 2131690596, 2131719544, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = asee.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((bbgg)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((bbgg)localObject).show();
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
      Object localObject = bahk.a(paramString2);
      localObject = ((aows)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a((String)localObject);
      if ((!apue.a()) || (paramLong <= ((amxu)localObject).b)) {
        break;
      }
    } while (!bcvm.a(this.jdField_a_of_type_AndroidAppActivity, 1, new azqb(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new azqc(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131697647, new Object[] { bakj.a(paramString2), bakj.a(paramLong) });
    paramString1 = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697850), paramString2, 2131690596, 2131697583, paramString1, paramString1);
    paramString2 = asee.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
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
    if (apue.a())
    {
      azpu localazpu = new azpu(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131697651, new Object[] { bakj.a(paramUUID.g), bakj.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131697650))
      {
        bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697850), paramUUID, 2131690596, 2131697942, localazpu, localazpu).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(azpg paramazpg)
  {
    paramazpg = new azqg(this, paramazpg);
    bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697539), b(2131697538), 2131690596, 2131694793, paramazpg, paramazpg).show();
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
      azqt localazqt = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject;
      if (localazqt != null)
      {
        l = localazqt.jdField_c_of_type_Long;
        localObject = b(2131697649, new Object[] { bakj.a(localazqt.g), bakj.a(localazqt.jdField_c_of_type_Long) });
      }
      while (l > ((aows)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bahk.a(localazqt.g)).b)
      {
        paramUUID = new azqe(this, localTroopFileTransferManager, paramUUID);
        paramUUID = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697850), (String)localObject, 2131690596, 2131697938, paramUUID, paramUUID);
        localObject = asee.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
        localObject = b(2131697648);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(azpg paramazpg)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new azpv(this, localTroopFileTransferManager, paramazpg), false);
  }
  
  public void d(azpg paramazpg)
  {
    int i = a(false);
    Object localObject = new azpx(this, paramazpg);
    if (i == 1) {}
    for (paramazpg = b(2131697649, new Object[] { bakj.a(paramazpg.jdField_c_of_type_JavaLangString), paramazpg.a() });; paramazpg = b(2131697940, new Object[] { bakj.a(paramazpg.jdField_c_of_type_JavaLangString) }))
    {
      localObject = bbcv.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697939), paramazpg, 2131690596, 2131697938, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        paramazpg = asee.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramazpg);
        if ((paramazpg instanceof SpannableString)) {
          ((bbgg)localObject).setMessageWithoutAutoLink(paramazpg);
        }
      }
      ((bbgg)localObject).show();
      return;
    }
  }
  
  public void e(azpg paramazpg)
  {
    boolean bool2 = false;
    bfol localbfol = (bfol)bfoy.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968667);
    boolean bool1 = bool2;
    if (paramazpg.e == 11)
    {
      bool1 = bool2;
      if (apvb.b(paramazpg.h))
      {
        localbfol.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramazpg.b()))) {
      localbfol.a(arrayOfString[1], 1);
    }
    localbfol.a(new azpy(this, bool1, paramazpg, localbfol));
    localbfol.c(2131690596);
    localbfol.show();
  }
  
  public void f(azpg paramazpg)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131697593);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131697580), new Object[] { bakj.a(paramazpg.jdField_c_of_type_JavaLangString) });
    bbgg localbbgg = bbcv.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbbgg.setTitle(str1).setMessage(str2);
    localbbgg.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694793), new azpz(this, paramazpg));
    localbbgg.show();
  }
  
  public void g(azpg paramazpg)
  {
    if (a() != 0)
    {
      bajk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramazpg);
      axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azpt
 * JD-Core Version:    0.7.0.1
 */