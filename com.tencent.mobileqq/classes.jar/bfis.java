import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.text.SpannableString;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation.9;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.UUID;

public class bfis
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public bfis(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      return bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return bgke.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public int a(bfif parambfif)
  {
    if ("/".equals(parambfif.g)) {
      return 0;
    }
    return 1;
  }
  
  public bfjs a(bfif parambfif)
  {
    bfjs localbfjs2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambfif.b);
    bfjs localbfjs1 = localbfjs2;
    if (localbfjs2 == null)
    {
      localbfjs1 = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambfif.jdField_a_of_type_JavaUtilUUID.toString(), parambfif.b, parambfif.jdField_c_of_type_JavaLangString, parambfif.jdField_a_of_type_Long, parambfif.jdField_a_of_type_Int);
      localbfjs1.jdField_c_of_type_JavaLangString = parambfif.k;
      localbfjs1.d = parambfif.l;
      localbfjs1.b = parambfif.j;
    }
    if ((localbfjs1 != null) && (localbfjs1.jdField_c_of_type_Long == 0L)) {
      localbfjs1.jdField_c_of_type_Long = parambfif.jdField_a_of_type_Long;
    }
    return localbfjs1;
  }
  
  public void a(bfif parambfif)
  {
    parambfif = new bfje(this, parambfif);
    bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697014), b(2131697013), 2131690697, 2131694399, parambfif, parambfif).show();
  }
  
  public void a(bfif parambfif, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = bhdj.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localQQCustomDialog.getMessageTextView().setLayoutParams(paramString1);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694399), new bfiz(this, parambfif));
    localQQCustomDialog.show();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new bfjc(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131697124, new Object[] { bgke.a(paramFileManagerEntity.fileName), bgke.a(paramFileManagerEntity.fileSize) });
      localObject = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697353), paramFileManagerEntity, 2131690697, 2131718826, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = awtc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((QQCustomDialog)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((QQCustomDialog)localObject).show();
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
      Object localObject = bghd.a(paramString2);
      localObject = ((atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER)).a((String)localObject);
      if ((!auea.a()) || (paramLong <= ((arip)localObject).b)) {
        break;
      }
    } while (!bixr.a(this.jdField_a_of_type_AndroidAppActivity, 1, new bfja(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new bfjb(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131697125, new Object[] { bgke.a(paramString2), bgke.a(paramLong) });
    paramString1 = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697353), paramString2, 2131690697, 2131697060, paramString1, paramString1);
    paramString2 = awtc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
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
    if (auea.a())
    {
      bfit localbfit = new bfit(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131697129, new Object[] { bgke.a(paramUUID.g), bgke.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131697128))
      {
        bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697353), paramUUID, 2131690697, 2131697446, localbfit, localbfit).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(bfif parambfif)
  {
    parambfif = new bfjf(this, parambfif);
    bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697010), b(2131697009), 2131690697, 2131694399, parambfif, parambfif).show();
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
      Object localObject2 = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject1;
      if (localObject2 != null)
      {
        l = ((bfjs)localObject2).jdField_c_of_type_Long;
        localObject1 = b(2131697127, new Object[] { bgke.a(((bfjs)localObject2).g), bgke.a(((bfjs)localObject2).jdField_c_of_type_Long) });
      }
      for (localObject2 = ((bfjs)localObject2).g; l > ((atix)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QFILE_CONFIG_MANAGER)).a(bghd.a((String)localObject2)).b; localObject2 = "")
      {
        paramUUID = new bfjd(this, localTroopFileTransferManager, paramUUID);
        paramUUID = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697353), (String)localObject1, 2131690697, 2131697442, paramUUID, paramUUID);
        localObject1 = awtc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject1);
        if ((localObject1 instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject1);
        }
        paramUUID.show();
        return;
        localObject1 = b(2131697126);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(bfif parambfif)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new bfiu(this, localTroopFileTransferManager, parambfif), false);
  }
  
  public void d(bfif parambfif)
  {
    int i = a(false);
    Object localObject = new bfiw(this, parambfif);
    if (i == 1) {}
    for (parambfif = b(2131697127, new Object[] { bgke.a(parambfif.jdField_c_of_type_JavaLangString), parambfif.a() });; parambfif = b(2131697444, new Object[] { bgke.a(parambfif.jdField_c_of_type_JavaLangString) }))
    {
      localObject = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697443), parambfif, 2131690697, 2131697442, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        parambfif = awtc.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, parambfif);
        if ((parambfif instanceof SpannableString)) {
          ((QQCustomDialog)localObject).setMessageWithoutAutoLink(parambfif);
        }
      }
      ((QQCustomDialog)localObject).show();
      return;
    }
  }
  
  public void e(bfif parambfif)
  {
    boolean bool2 = false;
    bkzi localbkzi = (bkzi)bkzz.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968671);
    boolean bool1 = bool2;
    if (parambfif.e == 11)
    {
      bool1 = bool2;
      if (FileUtil.fileExistsAndNotEmpty(parambfif.i))
      {
        localbkzi.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(parambfif.b()))) {
      localbkzi.a(arrayOfString[1], 1);
    }
    localbkzi.a(new bfix(this, bool1, parambfif, localbkzi));
    localbkzi.c(2131690697);
    localbkzi.show();
  }
  
  public void f(bfif parambfif)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131697071);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131697057), new Object[] { bgke.a(parambfif.jdField_c_of_type_JavaLangString) });
    QQCustomDialog localQQCustomDialog = bhdj.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694399), new bfiy(this, parambfif));
    localQQCustomDialog.show();
  }
  
  public void g(bfif parambfif)
  {
    if (a() != 0)
    {
      bgjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambfif);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfis
 * JD-Core Version:    0.7.0.1
 */