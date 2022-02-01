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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation.9;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.UUID;

public class bebp
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public bebp(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      return bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return bfby.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public int a(bebc parambebc)
  {
    if ("/".equals(parambebc.f)) {
      return 0;
    }
    return 1;
  }
  
  public becp a(bebc parambebc)
  {
    becp localbecp2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambebc.b);
    becp localbecp1 = localbecp2;
    if (localbecp2 == null)
    {
      localbecp1 = bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambebc.jdField_a_of_type_JavaUtilUUID.toString(), parambebc.b, parambebc.jdField_c_of_type_JavaLangString, parambebc.jdField_a_of_type_Long, parambebc.jdField_a_of_type_Int);
      localbecp1.jdField_c_of_type_JavaLangString = parambebc.j;
      localbecp1.d = parambebc.k;
      localbecp1.b = parambebc.i;
    }
    if ((localbecp1 != null) && (localbecp1.jdField_c_of_type_Long == 0L)) {
      localbecp1.jdField_c_of_type_Long = parambebc.jdField_a_of_type_Long;
    }
    return localbecp1;
  }
  
  public void a(bebc parambebc)
  {
    parambebc = new becb(this, parambebc);
    bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696747), b(2131696746), 2131690620, 2131694201, parambebc, parambebc).show();
  }
  
  public void a(bebc parambebc, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = bfur.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localQQCustomDialog.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localQQCustomDialog.getMessageTextView().setLayoutParams(paramString1);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694201), new bebw(this, parambebc));
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
      Object localObject = new bebz(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131696856, new Object[] { bfby.a(paramFileManagerEntity.fileName), bfby.a(paramFileManagerEntity.fileSize) });
      localObject = bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697076), paramFileManagerEntity, 2131690620, 2131718440, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = avmx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
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
      Object localObject = beyy.a(paramString2);
      localObject = ((aser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a((String)localObject);
      if ((!aszt.a()) || (paramLong <= ((aqfi)localObject).b)) {
        break;
      }
    } while (!bhnb.a(this.jdField_a_of_type_AndroidAppActivity, 1, new bebx(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new beby(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131696857, new Object[] { bfby.a(paramString2), bfby.a(paramLong) });
    paramString1 = bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697076), paramString2, 2131690620, 2131696793, paramString1, paramString1);
    paramString2 = avmx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
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
    if (aszt.a())
    {
      bebq localbebq = new bebq(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131696861, new Object[] { bfby.a(paramUUID.g), bfby.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131696860))
      {
        bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697076), paramUUID, 2131690620, 2131697169, localbebq, localbebq).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(bebc parambebc)
  {
    parambebc = new becc(this, parambebc);
    bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696743), b(2131696742), 2131690620, 2131694201, parambebc, parambebc).show();
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
        l = ((becp)localObject2).jdField_c_of_type_Long;
        localObject1 = b(2131696859, new Object[] { bfby.a(((becp)localObject2).g), bfby.a(((becp)localObject2).jdField_c_of_type_Long) });
      }
      for (localObject2 = ((becp)localObject2).g; l > ((aser)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(beyy.a((String)localObject2)).b; localObject2 = "")
      {
        paramUUID = new beca(this, localTroopFileTransferManager, paramUUID);
        paramUUID = bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697076), (String)localObject1, 2131690620, 2131697165, paramUUID, paramUUID);
        localObject1 = avmx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject1);
        if ((localObject1 instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject1);
        }
        paramUUID.show();
        return;
        localObject1 = b(2131696858);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(bebc parambebc)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new bebr(this, localTroopFileTransferManager, parambebc), false);
  }
  
  public void d(bebc parambebc)
  {
    int i = a(false);
    Object localObject = new bebt(this, parambebc);
    if (i == 1) {}
    for (parambebc = b(2131696859, new Object[] { bfby.a(parambebc.jdField_c_of_type_JavaLangString), parambebc.a() });; parambebc = b(2131697167, new Object[] { bfby.a(parambebc.jdField_c_of_type_JavaLangString) }))
    {
      localObject = bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697166), parambebc, 2131690620, 2131697165, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        parambebc = avmx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, parambebc);
        if ((parambebc instanceof SpannableString)) {
          ((QQCustomDialog)localObject).setMessageWithoutAutoLink(parambebc);
        }
      }
      ((QQCustomDialog)localObject).show();
      return;
    }
  }
  
  public void e(bebc parambebc)
  {
    boolean bool2 = false;
    bjnw localbjnw = (bjnw)bjon.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968671);
    boolean bool1 = bool2;
    if (parambebc.e == 11)
    {
      bool1 = bool2;
      if (FileUtil.fileExistsAndNotEmpty(parambebc.h))
      {
        localbjnw.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(parambebc.b()))) {
      localbjnw.a(arrayOfString[1], 1);
    }
    localbjnw.a(new bebu(this, bool1, parambebc, localbjnw));
    localbjnw.c(2131690620);
    localbjnw.show();
  }
  
  public void f(bebc parambebc)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131696803);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131696790), new Object[] { bfby.a(parambebc.jdField_c_of_type_JavaLangString) });
    QQCustomDialog localQQCustomDialog = bfur.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localQQCustomDialog.setTitle(str1).setMessage(str2);
    localQQCustomDialog.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694201), new bebv(this, parambebc));
    localQQCustomDialog.show();
  }
  
  public void g(bebc parambebc)
  {
    if (a() != 0)
    {
      bfbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambebc);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebp
 * JD-Core Version:    0.7.0.1
 */