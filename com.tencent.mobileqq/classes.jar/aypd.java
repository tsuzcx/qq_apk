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

public class aypd
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public aypd(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      return azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return azjg.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public int a(ayoq paramayoq)
  {
    if ("/".equals(paramayoq.f)) {
      return 0;
    }
    return 1;
  }
  
  public ayqd a(ayoq paramayoq)
  {
    ayqd localayqd2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramayoq.b);
    ayqd localayqd1 = localayqd2;
    if (localayqd2 == null)
    {
      localayqd1 = azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, paramayoq.jdField_a_of_type_JavaUtilUUID.toString(), paramayoq.b, paramayoq.jdField_c_of_type_JavaLangString, paramayoq.jdField_a_of_type_Long, paramayoq.jdField_a_of_type_Int);
      localayqd1.jdField_c_of_type_JavaLangString = paramayoq.j;
      localayqd1.d = paramayoq.k;
      localayqd1.b = paramayoq.i;
    }
    if ((localayqd1 != null) && (localayqd1.jdField_c_of_type_Long == 0L)) {
      localayqd1.jdField_c_of_type_Long = paramayoq.jdField_a_of_type_Long;
    }
    return localayqd1;
  }
  
  public void a(ayoq paramayoq)
  {
    paramayoq = new aypp(this, paramayoq);
    babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131631831), b(2131631830), 2131625035, 2131629116, paramayoq, paramayoq).show();
  }
  
  public void a(ayoq paramayoq, String paramString1, String paramString2)
  {
    bafb localbafb = babr.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbafb.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localbafb.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localbafb.getMessageTextView().setLayoutParams(paramString1);
    localbafb.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131629116), new aypk(this, paramayoq));
    localbafb.show();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new aypn(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131631932, new Object[] { azjg.a(paramFileManagerEntity.fileName), azjg.a(paramFileManagerEntity.fileSize) });
      localObject = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131632130), paramFileManagerEntity, 2131625035, 2131653660, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = aric.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((bafb)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((bafb)localObject).show();
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
      Object localObject = azgh.a(paramString2);
      localObject = ((aofy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a((String)localObject);
      if ((!apck.a()) || (paramLong <= ((amhq)localObject).b)) {
        break;
      }
    } while (!bbrm.a(this.jdField_a_of_type_AndroidAppActivity, 1, new aypl(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new aypm(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131631933, new Object[] { azjg.a(paramString2), azjg.a(paramLong) });
    paramString1 = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131632130), paramString2, 2131625035, 2131631869, paramString1, paramString1);
    paramString2 = aric.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
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
    if (apck.a())
    {
      aype localaype = new aype(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131631937, new Object[] { azjg.a(paramUUID.g), azjg.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131631936))
      {
        babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131632130), paramUUID, 2131625035, 2131632217, localaype, localaype).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(ayoq paramayoq)
  {
    paramayoq = new aypq(this, paramayoq);
    babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131631827), b(2131631826), 2131625035, 2131629116, paramayoq, paramayoq).show();
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
      ayqd localayqd = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject;
      if (localayqd != null)
      {
        l = localayqd.jdField_c_of_type_Long;
        localObject = b(2131631935, new Object[] { azjg.a(localayqd.g), azjg.a(localayqd.jdField_c_of_type_Long) });
      }
      while (l > ((aofy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(azgh.a(localayqd.g)).b)
      {
        paramUUID = new aypo(this, localTroopFileTransferManager, paramUUID);
        paramUUID = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131632130), (String)localObject, 2131625035, 2131632213, paramUUID, paramUUID);
        localObject = aric.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
        localObject = b(2131631934);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(ayoq paramayoq)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new aypf(this, localTroopFileTransferManager, paramayoq), false);
  }
  
  public void d(ayoq paramayoq)
  {
    int i = a(false);
    Object localObject = new ayph(this, paramayoq);
    if (i == 1) {}
    for (paramayoq = b(2131631935, new Object[] { azjg.a(paramayoq.jdField_c_of_type_JavaLangString), paramayoq.a() });; paramayoq = b(2131632215, new Object[] { azjg.a(paramayoq.jdField_c_of_type_JavaLangString) }))
    {
      localObject = babr.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131632214), paramayoq, 2131625035, 2131632213, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        paramayoq = aric.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramayoq);
        if ((paramayoq instanceof SpannableString)) {
          ((bafb)localObject).setMessageWithoutAutoLink(paramayoq);
        }
      }
      ((bafb)localObject).show();
      return;
    }
  }
  
  public void e(ayoq paramayoq)
  {
    boolean bool2 = false;
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130903131);
    boolean bool1 = bool2;
    if (paramayoq.e == 11)
    {
      bool1 = bool2;
      if (apdh.b(paramayoq.h))
      {
        localbegr.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramayoq.b()))) {
      localbegr.a(arrayOfString[1], 1);
    }
    localbegr.a(new aypi(this, bool1, paramayoq, localbegr));
    localbegr.c(2131625035);
    localbegr.show();
  }
  
  public void f(ayoq paramayoq)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131631879);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131631866), new Object[] { azjg.a(paramayoq.jdField_c_of_type_JavaLangString) });
    bafb localbafb = babr.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbafb.setTitle(str1).setMessage(str2);
    localbafb.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131629116), new aypj(this, paramayoq));
    localbafb.show();
  }
  
  public void g(ayoq paramayoq)
  {
    if (a() != 0)
    {
      azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(paramayoq);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aypd
 * JD-Core Version:    0.7.0.1
 */