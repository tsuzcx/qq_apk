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

public class besy
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public besy(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      return bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return bfsj.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public int a(besl parambesl)
  {
    if ("/".equals(parambesl.f)) {
      return 0;
    }
    return 1;
  }
  
  public bety a(besl parambesl)
  {
    bety localbety2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambesl.b);
    bety localbety1 = localbety2;
    if (localbety2 == null)
    {
      localbety1 = bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambesl.jdField_a_of_type_JavaUtilUUID.toString(), parambesl.b, parambesl.jdField_c_of_type_JavaLangString, parambesl.jdField_a_of_type_Long, parambesl.jdField_a_of_type_Int);
      localbety1.jdField_c_of_type_JavaLangString = parambesl.j;
      localbety1.d = parambesl.k;
      localbety1.b = parambesl.i;
    }
    if ((localbety1 != null) && (localbety1.jdField_c_of_type_Long == 0L)) {
      localbety1.jdField_c_of_type_Long = parambesl.jdField_a_of_type_Long;
    }
    return localbety1;
  }
  
  public void a(besl parambesl)
  {
    parambesl = new betk(this, parambesl);
    bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696563), b(2131696562), 2131690582, 2131694081, parambesl, parambesl).show();
  }
  
  public void a(besl parambesl, String paramString1, String paramString2)
  {
    bgpa localbgpa = bglp.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbgpa.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localbgpa.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localbgpa.getMessageTextView().setLayoutParams(paramString1);
    localbgpa.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694081), new betf(this, parambesl));
    localbgpa.show();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new beti(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131696666, new Object[] { bfsj.a(paramFileManagerEntity.fileName), bfsj.a(paramFileManagerEntity.fileSize) });
      localObject = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696885), paramFileManagerEntity, 2131690582, 2131718066, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = awgy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((bgpa)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((bgpa)localObject).show();
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
      Object localObject = bfpj.a(paramString2);
      localObject = ((atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a((String)localObject);
      if ((!atvo.a()) || (paramLong <= ((aqvx)localObject).b)) {
        break;
      }
    } while (!bigl.a(this.jdField_a_of_type_AndroidAppActivity, 1, new betg(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new beth(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131696667, new Object[] { bfsj.a(paramString2), bfsj.a(paramLong) });
    paramString1 = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696885), paramString2, 2131690582, 2131696603, paramString1, paramString1);
    paramString2 = awgy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
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
    if (atvo.a())
    {
      besz localbesz = new besz(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131696671, new Object[] { bfsj.a(paramUUID.g), bfsj.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131696670))
      {
        bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696885), paramUUID, 2131690582, 2131696978, localbesz, localbesz).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(besl parambesl)
  {
    parambesl = new betl(this, parambesl);
    bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696559), b(2131696558), 2131690582, 2131694081, parambesl, parambesl).show();
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
      bety localbety = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject;
      if (localbety != null)
      {
        l = localbety.jdField_c_of_type_Long;
        localObject = b(2131696669, new Object[] { bfsj.a(localbety.g), bfsj.a(localbety.jdField_c_of_type_Long) });
      }
      while (l > ((atam)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bfpj.a(localbety.g)).b)
      {
        paramUUID = new betj(this, localTroopFileTransferManager, paramUUID);
        paramUUID = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696885), (String)localObject, 2131690582, 2131696974, paramUUID, paramUUID);
        localObject = awgy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
        localObject = b(2131696668);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(besl parambesl)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new beta(this, localTroopFileTransferManager, parambesl), false);
  }
  
  public void d(besl parambesl)
  {
    int i = a(false);
    Object localObject = new betc(this, parambesl);
    if (i == 1) {}
    for (parambesl = b(2131696669, new Object[] { bfsj.a(parambesl.jdField_c_of_type_JavaLangString), parambesl.a() });; parambesl = b(2131696976, new Object[] { bfsj.a(parambesl.jdField_c_of_type_JavaLangString) }))
    {
      localObject = bglp.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696975), parambesl, 2131690582, 2131696974, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        parambesl = awgy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, parambesl);
        if ((parambesl instanceof SpannableString)) {
          ((bgpa)localObject).setMessageWithoutAutoLink(parambesl);
        }
      }
      ((bgpa)localObject).show();
      return;
    }
  }
  
  public void e(besl parambesl)
  {
    boolean bool2 = false;
    bkho localbkho = (bkho)bkif.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968671);
    boolean bool1 = bool2;
    if (parambesl.e == 11)
    {
      bool1 = bool2;
      if (atwl.b(parambesl.h))
      {
        localbkho.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(parambesl.b()))) {
      localbkho.a(arrayOfString[1], 1);
    }
    localbkho.a(new betd(this, bool1, parambesl, localbkho));
    localbkho.c(2131690582);
    localbkho.show();
  }
  
  public void f(besl parambesl)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131696613);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131696600), new Object[] { bfsj.a(parambesl.jdField_c_of_type_JavaLangString) });
    bgpa localbgpa = bglp.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbgpa.setTitle(str1).setMessage(str2);
    localbgpa.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694081), new bete(this, parambesl));
    localbgpa.show();
  }
  
  public void g(besl parambesl)
  {
    if (a() != 0)
    {
      bfrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambesl);
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besy
 * JD-Core Version:    0.7.0.1
 */