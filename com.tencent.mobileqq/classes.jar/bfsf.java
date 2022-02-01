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

public class bfsf
{
  public long a;
  public Activity a;
  public QQAppInterface a;
  
  public bfsf(long paramLong, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      return bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Long);
    }
    return bgsk.a(this.jdField_a_of_type_AndroidAppActivity);
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
  
  public int a(bfrs parambfrs)
  {
    if ("/".equals(parambfrs.f)) {
      return 0;
    }
    return 1;
  }
  
  public bftf a(bfrs parambfrs)
  {
    bftf localbftf2 = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambfrs.b);
    bftf localbftf1 = localbftf2;
    if (localbftf2 == null)
    {
      localbftf1 = bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, parambfrs.jdField_a_of_type_JavaUtilUUID.toString(), parambfrs.b, parambfrs.jdField_c_of_type_JavaLangString, parambfrs.jdField_a_of_type_Long, parambfrs.jdField_a_of_type_Int);
      localbftf1.jdField_c_of_type_JavaLangString = parambfrs.j;
      localbftf1.d = parambfrs.k;
      localbftf1.b = parambfrs.i;
    }
    if ((localbftf1 != null) && (localbftf1.jdField_c_of_type_Long == 0L)) {
      localbftf1.jdField_c_of_type_Long = parambfrs.jdField_a_of_type_Long;
    }
    return localbftf1;
  }
  
  public void a(bfrs parambfrs)
  {
    parambfrs = new bfsr(this, parambfrs);
    bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696606), b(2131696605), 2131690580, 2131694098, parambfrs, parambfrs).show();
  }
  
  public void a(bfrs parambfrs, String paramString1, String paramString2)
  {
    bhpc localbhpc = bhlq.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbhpc.setTitle(paramString1).setMessage(paramString2);
    paramString1 = (LinearLayout.LayoutParams)localbhpc.getMessageTextView().getLayoutParams();
    paramString1.gravity = 17;
    localbhpc.getMessageTextView().setLayoutParams(paramString1);
    localbhpc.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694098), new bfsm(this, parambfrs));
    localbhpc.show();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    int i = a();
    if (i == 0) {
      return;
    }
    if ((i == 1) && (paramFileManagerEntity.fileSize > 3145728L))
    {
      Object localObject = new bfsp(this, paramFileManagerEntity);
      paramFileManagerEntity = b(2131696715, new Object[] { bgsk.a(paramFileManagerEntity.fileName), bgsk.a(paramFileManagerEntity.fileSize) });
      localObject = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696934), paramFileManagerEntity, 2131690580, 2131718199, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      paramFileManagerEntity = awzq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramFileManagerEntity);
      if ((paramFileManagerEntity instanceof SpannableString)) {
        ((bhpc)localObject).setMessageWithoutAutoLink(paramFileManagerEntity);
      }
      ((bhpc)localObject).show();
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
      Object localObject = bgpk.a(paramString2);
      localObject = ((atsh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a((String)localObject);
      if ((!aunj.a()) || (paramLong <= ((arll)localObject).b)) {
        break;
      }
    } while (!bjhk.a(this.jdField_a_of_type_AndroidAppActivity, 1, new bfsn(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt)));
    paramString1 = new bfso(this, localTroopFileTransferManager, paramString1, paramString2, paramLong, paramInt);
    paramString2 = b(2131696716, new Object[] { bgsk.a(paramString2), bgsk.a(paramLong) });
    paramString1 = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696934), paramString2, 2131690580, 2131696652, paramString1, paramString1);
    paramString2 = awzq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, paramString2);
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
    if (aunj.a())
    {
      bfsg localbfsg = new bfsg(this, localTroopFileTransferManager, paramUUID);
      paramUUID = localTroopFileTransferManager.a(paramUUID);
      if (paramUUID != null) {}
      for (paramUUID = b(2131696720, new Object[] { bgsk.a(paramUUID.g), bgsk.a(paramUUID.jdField_c_of_type_Long) });; paramUUID = b(2131696719))
      {
        bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696934), paramUUID, 2131690580, 2131697027, localbfsg, localbfsg).show();
        return;
      }
    }
    localTroopFileTransferManager.b(paramUUID);
  }
  
  public void b(bfrs parambfrs)
  {
    parambfrs = new bfss(this, parambfrs);
    bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696602), b(2131696601), 2131690580, 2131694098, parambfrs, parambfrs).show();
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
      bftf localbftf = localTroopFileTransferManager.a(paramUUID);
      long l;
      Object localObject;
      if (localbftf != null)
      {
        l = localbftf.jdField_c_of_type_Long;
        localObject = b(2131696718, new Object[] { bgsk.a(localbftf.g), bgsk.a(localbftf.jdField_c_of_type_Long) });
      }
      while (l > ((atsh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(317)).a(bgpk.a(localbftf.g)).b)
      {
        paramUUID = new bfsq(this, localTroopFileTransferManager, paramUUID);
        paramUUID = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131696934), (String)localObject, 2131690580, 2131697023, paramUUID, paramUUID);
        localObject = awzq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, (String)localObject);
        if ((localObject instanceof SpannableString)) {
          paramUUID.setMessageWithoutAutoLink((CharSequence)localObject);
        }
        paramUUID.show();
        return;
        localObject = b(2131696717);
        l = 0L;
      }
      localTroopFileTransferManager.c(paramUUID);
      return;
    }
    localTroopFileTransferManager.c(paramUUID);
  }
  
  public void c(bfrs parambfrs)
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    ThreadManager.post(new TroopFileItemOperation.9(this, localTroopFileTransferManager), 8, new bfsh(this, localTroopFileTransferManager, parambfrs), false);
  }
  
  public void d(bfrs parambfrs)
  {
    int i = a(false);
    Object localObject = new bfsj(this, parambfrs);
    if (i == 1) {}
    for (parambfrs = b(2131696718, new Object[] { bgsk.a(parambfrs.jdField_c_of_type_JavaLangString), parambfrs.a() });; parambfrs = b(2131697025, new Object[] { bgsk.a(parambfrs.jdField_c_of_type_JavaLangString) }))
    {
      localObject = bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, b(2131697024), parambfrs, 2131690580, 2131697023, (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject);
      if (i == 1)
      {
        parambfrs = awzq.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2, parambfrs);
        if ((parambfrs instanceof SpannableString)) {
          ((bhpc)localObject).setMessageWithoutAutoLink(parambfrs);
        }
      }
      ((bhpc)localObject).show();
      return;
    }
  }
  
  public void e(bfrs parambfrs)
  {
    boolean bool2 = false;
    blir localblir = (blir)blji.a(this.jdField_a_of_type_AndroidAppActivity, null);
    String[] arrayOfString = this.jdField_a_of_type_AndroidAppActivity.getResources().getStringArray(2130968671);
    boolean bool1 = bool2;
    if (parambfrs.e == 11)
    {
      bool1 = bool2;
      if (auog.b(parambfrs.h))
      {
        localblir.a(arrayOfString[0], 1);
        bool1 = true;
      }
    }
    if ((bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(parambfrs.b()))) {
      localblir.a(arrayOfString[1], 1);
    }
    localblir.a(new bfsk(this, bool1, parambfrs, localblir));
    localblir.c(2131690580);
    localblir.show();
  }
  
  public void f(bfrs parambfrs)
  {
    String str1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131696662);
    String str2 = String.format(this.jdField_a_of_type_AndroidAppActivity.getString(2131696649), new Object[] { bgsk.a(parambfrs.jdField_c_of_type_JavaLangString) });
    bhpc localbhpc = bhlq.b(this.jdField_a_of_type_AndroidAppActivity, 230);
    localbhpc.setTitle(str1).setMessage(str2);
    localbhpc.setPositiveButton(this.jdField_a_of_type_AndroidAppActivity.getString(2131694098), new bfsl(this, parambfrs));
    localbhpc.show();
  }
  
  public void g(bfrs parambfrs)
  {
    if (a() != 0)
    {
      bgrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long).a(parambfrs);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.jdField_a_of_type_Long + "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsf
 * JD-Core Version:    0.7.0.1
 */