import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.ArrayList;
import java.util.List;

public class aosf
  extends aosi
{
  protected aosf(QQAppInterface paramQQAppInterface, aosm paramaosm)
  {
    super(paramQQAppInterface, paramaosm);
  }
  
  public int a(QQMessageFacade.Message paramMessage)
  {
    return 267;
  }
  
  public aosm a(QQMessageFacade.Message paramMessage)
  {
    Object localObject3 = bhbd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130840440));
    this.jdField_a_of_type_Aosm.a((Bitmap)localObject3);
    Object localObject2 = c();
    this.jdField_a_of_type_Aosm.d((String)localObject2);
    Object localObject4 = afuo.a(paramMessage);
    Object localObject1 = localObject2;
    if (localObject4 != null)
    {
      localObject1 = localObject2;
      if (!((PAMessage)localObject4).items.isEmpty())
      {
        localObject1 = ((PAMessage.Item)((PAMessage)localObject4).items.get(0)).title;
        if ((((PAMessage.Item)((PAMessage)localObject4).items.get(0)).cover != null) || (((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList == null)) {
          break label214;
        }
        this.jdField_a_of_type_Aosm.c((String)localObject1);
        localObject1 = (String)((PAMessage.Item)((PAMessage)localObject4).items.get(0)).digestList.get(0);
        this.jdField_a_of_type_Aosm.d((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_Aosm.b();
      localObject2 = (String)localObject2 + (String)localObject1;
      this.jdField_a_of_type_Aosm.b((String)localObject2);
      a(paramMessage, this.jdField_a_of_type_Aosm);
      if (paramMessage.extStr != null) {
        break;
      }
      return null;
      label214:
      this.jdField_a_of_type_Aosm.d((String)localObject1);
    }
    if (((paramMessage.extLong & 0x1) == 0) && (!paramMessage.extStr.contains("lockDisplay"))) {
      return null;
    }
    if (((paramMessage.extLong & 0x1) == 1) && (!paramMessage.getExtInfoFromExtStr("lockDisplay").equals("true"))) {
      return null;
    }
    Intent localIntent = this.jdField_a_of_type_Aosm.a();
    localObject4 = this.jdField_a_of_type_Aosm.c();
    String str1 = this.jdField_a_of_type_Aosm.a();
    localIntent.putExtra("need_report", true);
    localIntent.putExtra("incoming_msguid", paramMessage.msgUid);
    localIntent.putExtra("incoming_shmsgseq", paramMessage.shmsgseq);
    String str2 = localIntent.getStringExtra("uin");
    if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty(str2))) {}
    for (localObject2 = ((String)localObject4).replace(str2, "");; localObject2 = localObject4)
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      while (AppConstants.REMINDER_UIN.equals(str2))
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramMessage.frienduin, true);
        localObject2 = localObject1;
        pkh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade(), paramMessage, localIntent);
        this.jdField_a_of_type_Aosm.a(localIntent);
        this.jdField_a_of_type_Aosm.c((String)localObject4);
        this.jdField_a_of_type_Aosm.d((String)localObject2);
        this.jdField_a_of_type_Aosm.b((String)localObject1);
        this.jdField_a_of_type_Aosm.a((Bitmap)localObject3);
        return this.jdField_a_of_type_Aosm;
        localObject1 = (String)localObject2 + " : " + (String)localObject1;
      }
      if (AppConstants.KANDIAN_DAILY_UIN.equals(str2))
      {
        localObject2 = BaseApplicationImpl.getContext().getResources().getDrawable(2130842738);
        if ((localObject2 instanceof BitmapDrawable)) {
          localObject2 = ((BitmapDrawable)localObject2).getBitmap();
        }
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = str1;
        break;
        if ((localObject2 instanceof SkinnableBitmapDrawable))
        {
          localObject2 = ((SkinnableBitmapDrawable)localObject2).getBitmap();
          continue;
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131689656);
          localObject2 = localObject1;
          break;
        }
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosf
 * JD-Core Version:    0.7.0.1
 */