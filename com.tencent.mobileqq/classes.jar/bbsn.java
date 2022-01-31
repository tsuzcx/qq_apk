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

public class bbsn
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public bbsn(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      return bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return bcnt.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public int a(bbsa parambbsa)
  {
    if ("/".equals(parambbsa.f)) {
      return 0;
    }
    return 1;
  }
  
  public bbtn a(bbsa parambbsa)
  {
    bbtn localbbtn2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambbsa.b);
    bbtn localbbtn1 = localbbtn2;
    if (localbbtn2 == null)
    {
      localbbtn1 = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambbsa.jdField_a_of_type_JavaUtilUUID.toString(), parambbsa.b, parambbsa.jdField_c_of_type_JavaLangString, parambbsa.jdField_a_of_type_Long, parambbsa.jdField_a_of_type_Int);
      localbbtn1.jdField_c_of_type_JavaLangString = parambbsa.j;
      localbbtn1.d = parambbsa.k;
      localbbtn1.b = parambbsa.i;
    }
    if ((localbbtn1 != null) && (localbbtn1.jdField_c_of_type_Long == 0L)) {
      localbbtn1.jdField_c_of_type_Long = parambbsa.jdField_a_of_type_Long;
    }
    return localbbtn1;
  }
  
  public void a(bbsa parambbsa)
  {
    parambbsa = new bbsz(this, parambbsa);
    bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697721), b(2131697720), 2131690648, 2131694953, parambbsa, parambbsa).show();
  }
  
  public void a(bbsa parambbsa, String paramString1, String paramString2)
  {
    bdjz localbdjz = bdgm.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbdjz.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localbdjz.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localbdjz.getMessageTextView().setLayoutParams(paramString1);
    localbdjz.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694953), new bbsu(this, parambbsa));
    localbdjz.show();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new bbsx(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131697824, new Object[] { bcnt.a(paramFileManagerEntity.fileName), bcnt.a(paramFileManagerEntity.fileSize) });
      localObject = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698039), paramFileManagerEntity, 2131690648, 2131720099, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = atzp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((bdjz)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((bdjz)localObject).show();
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
      Object localObject = bckt.a(paramString2);
      localObject = ((aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a((String)localObject);
      if ((!arrr.a()) || (paramLong <= ((aotl)localObject).b)) {
        break;
      }
    } while (!bezm.a(this.jdField_a_of_type_AndroidAppActivity, 1, new bbsv(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new bbsw(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131697825, new Object[] { bcnt.a(paramString2), bcnt.a(paramLong) });
    paramString1 = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698039), paramString2, 2131690648, 2131697761, paramString1, paramString1);
    paramString2 = atzp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
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
    if (arrr.a())
    {
      bbso localbbso = new bbso(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131697829, new Object[] { bcnt.a(paramUUID.g), bcnt.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131697828))
      {
        bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698039), paramUUID, 2131690648, 2131698131, localbbso, localbbso).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(bbsa parambbsa)
  {
    parambbsa = new bbta(this, parambbsa);
    bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697717), b(2131697716), 2131690648, 2131694953, parambbsa, parambbsa).show();
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
      bbtn localbbtn = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject;
      if (localbbtn != null)
      {
        l = localbbtn.jdField_c_of_type_Long;
        localObject = b(2131697827, new Object[] { bcnt.a(localbbtn.g), bcnt.a(localbbtn.jdField_c_of_type_Long) });
      }
      while (l > ((aqud)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bckt.a(localbbtn.g)).b)
      {
        paramUUID = new bbsy(this, localTroopFileTransferManager, paramUUID);
        paramUUID = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698039), (String)localObject, 2131690648, 2131698127, paramUUID, paramUUID);
        localObject = atzp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
        localObject = b(2131697826);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(bbsa parambbsa)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new bbsp(this, localTroopFileTransferManager, parambbsa), false);
  }
  
  public void d(bbsa parambbsa)
  {
    int i = a(false);
    Object localObject = new bbsr(this, parambbsa);
    if (i == 1) {}
    for (parambbsa = b(2131697827, new Object[] { bcnt.a(parambbsa.jdField_c_of_type_JavaLangString), parambbsa.a() });; parambbsa = b(2131698129, new Object[] { bcnt.a(parambbsa.jdField_c_of_type_JavaLangString) }))
    {
      localObject = bdgm.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698128), parambbsa, 2131690648, 2131698127, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        parambbsa = atzp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, parambbsa);
        if ((parambbsa instanceof SpannableString)) {
          ((bdjz)localObject).setMessageWithoutAutoLink(parambbsa);
        }
      }
      ((bdjz)localObject).show();
      return;
    }
  }
  
  public void e(bbsa parambbsa)
  {
    boolean bool2 = false;
    bhuf localbhuf = (bhuf)bhus.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968669);
    boolean bool1 = bool2;
    if (parambbsa.e == 11)
    {
      bool1 = bool2;
      if (arso.b(parambbsa.h))
      {
        localbhuf.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(parambbsa.b()))) {
      localbhuf.a(arrayOfString[1], 1);
    }
    localbhuf.a(new bbss(this, bool1, parambbsa, localbhuf));
    localbhuf.c(2131690648);
    localbhuf.show();
  }
  
  public void f(bbsa parambbsa)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131697771);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131697758), new Object[] { bcnt.a(parambbsa.jdField_c_of_type_JavaLangString) });
    bdjz localbdjz = bdgm.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbdjz.setTitle(str1).setMessage(str2);
    localbdjz.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694953), new bbst(this, parambbsa));
    localbdjz.show();
  }
  
  public void g(bbsa parambbsa)
  {
    if (a() != 0)
    {
      bcmu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambbsa);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsn
 * JD-Core Version:    0.7.0.1
 */