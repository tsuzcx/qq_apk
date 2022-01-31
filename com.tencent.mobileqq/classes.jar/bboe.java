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

public class bboe
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public bboe(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      return bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return bcjk.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public int a(bbnr parambbnr)
  {
    if ("/".equals(parambbnr.f)) {
      return 0;
    }
    return 1;
  }
  
  public bbpe a(bbnr parambbnr)
  {
    bbpe localbbpe2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambbnr.b);
    bbpe localbbpe1 = localbbpe2;
    if (localbbpe2 == null)
    {
      localbbpe1 = bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambbnr.jdField_a_of_type_JavaUtilUUID.toString(), parambbnr.b, parambbnr.jdField_c_of_type_JavaLangString, parambbnr.jdField_a_of_type_Long, parambbnr.jdField_a_of_type_Int);
      localbbpe1.jdField_c_of_type_JavaLangString = parambbnr.j;
      localbbpe1.d = parambbnr.k;
      localbbpe1.b = parambbnr.i;
    }
    if ((localbbpe1 != null) && (localbbpe1.jdField_c_of_type_Long == 0L)) {
      localbbpe1.jdField_c_of_type_Long = parambbnr.jdField_a_of_type_Long;
    }
    return localbbpe1;
  }
  
  public void a(bbnr parambbnr)
  {
    parambbnr = new bboq(this, parambbnr);
    bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697719), b(2131697718), 2131690648, 2131694951, parambbnr, parambbnr).show();
  }
  
  public void a(bbnr parambbnr, String paramString1, String paramString2)
  {
    bdfq localbdfq = bdcd.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbdfq.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localbdfq.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localbdfq.getMessageTextView().setLayoutParams(paramString1);
    localbdfq.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694951), new bbol(this, parambbnr));
    localbdfq.show();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new bboo(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131697822, new Object[] { bcjk.a(paramFileManagerEntity.fileName), bcjk.a(paramFileManagerEntity.fileSize) });
      localObject = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698037), paramFileManagerEntity, 2131690648, 2131720087, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = atvg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((bdfq)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((bdfq)localObject).show();
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
      Object localObject = bcgk.a(paramString2);
      localObject = ((aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a((String)localObject);
      if ((!arni.a()) || (paramLong <= ((aopc)localObject).b)) {
        break;
      }
    } while (!bevd.a(this.jdField_a_of_type_AndroidAppActivity, 1, new bbom(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new bbon(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131697823, new Object[] { bcjk.a(paramString2), bcjk.a(paramLong) });
    paramString1 = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698037), paramString2, 2131690648, 2131697759, paramString1, paramString1);
    paramString2 = atvg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
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
    if (arni.a())
    {
      bbof localbbof = new bbof(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131697827, new Object[] { bcjk.a(paramUUID.g), bcjk.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131697826))
      {
        bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698037), paramUUID, 2131690648, 2131698129, localbbof, localbbof).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(bbnr parambbnr)
  {
    parambbnr = new bbor(this, parambbnr);
    bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697715), b(2131697714), 2131690648, 2131694951, parambbnr, parambbnr).show();
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
      bbpe localbbpe = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject;
      if (localbbpe != null)
      {
        l = localbbpe.jdField_c_of_type_Long;
        localObject = b(2131697825, new Object[] { bcjk.a(localbbpe.g), bcjk.a(localbbpe.jdField_c_of_type_Long) });
      }
      while (l > ((aqpu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bcgk.a(localbbpe.g)).b)
      {
        paramUUID = new bbop(this, localTroopFileTransferManager, paramUUID);
        paramUUID = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698037), (String)localObject, 2131690648, 2131698125, paramUUID, paramUUID);
        localObject = atvg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
        localObject = b(2131697824);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(bbnr parambbnr)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new bbog(this, localTroopFileTransferManager, parambbnr), false);
  }
  
  public void d(bbnr parambbnr)
  {
    int i = a(false);
    Object localObject = new bboi(this, parambbnr);
    if (i == 1) {}
    for (parambbnr = b(2131697825, new Object[] { bcjk.a(parambbnr.jdField_c_of_type_JavaLangString), parambbnr.a() });; parambbnr = b(2131698127, new Object[] { bcjk.a(parambbnr.jdField_c_of_type_JavaLangString) }))
    {
      localObject = bdcd.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131698126), parambbnr, 2131690648, 2131698125, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        parambbnr = atvg.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, parambbnr);
        if ((parambbnr instanceof SpannableString)) {
          ((bdfq)localObject).setMessageWithoutAutoLink(parambbnr);
        }
      }
      ((bdfq)localObject).show();
      return;
    }
  }
  
  public void e(bbnr parambbnr)
  {
    boolean bool2 = false;
    bhpy localbhpy = (bhpy)bhql.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968669);
    boolean bool1 = bool2;
    if (parambbnr.e == 11)
    {
      bool1 = bool2;
      if (arof.b(parambbnr.h))
      {
        localbhpy.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(parambbnr.b()))) {
      localbhpy.a(arrayOfString[1], 1);
    }
    localbhpy.a(new bboj(this, bool1, parambbnr, localbhpy));
    localbhpy.c(2131690648);
    localbhpy.show();
  }
  
  public void f(bbnr parambbnr)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131697769);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131697756), new Object[] { bcjk.a(parambbnr.jdField_c_of_type_JavaLangString) });
    bdfq localbdfq = bdcd.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbdfq.setTitle(str1).setMessage(str2);
    localbdfq.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694951), new bbok(this, parambbnr));
    localbdfq.show();
  }
  
  public void g(bbnr parambbnr)
  {
    if (a() != 0)
    {
      bcil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambbnr);
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboe
 * JD-Core Version:    0.7.0.1
 */