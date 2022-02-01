import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bain
  implements agin
{
  private int jdField_a_of_type_Int = 13;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public QQCustomDialog a;
  
  public bain(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp().getEntityManagerFactory().createEntityManager();
    }
  }
  
  private avhr a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = avia.a(new String(paramArrayOfByte, "utf-8"));
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private void a(EntityManager paramEntityManager, long paramLong)
  {
    bait.a().a(paramEntityManager, paramLong, new baio(this));
  }
  
  private void a(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 103) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)) {
      bait.a().a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramPushDialogTemplate);
    }
  }
  
  private void a(QQCustomDialog paramQQCustomDialog, avhr paramavhr, PushDialogTemplate paramPushDialogTemplate)
  {
    paramavhr = paramavhr.a();
    if (paramavhr.a() != 6) {}
    Object localObject3;
    Object localObject2;
    label438:
    do
    {
      return;
      for (;;)
      {
        paramavhr = paramavhr.a();
        if ((paramavhr != null) && (paramavhr.size() != 0))
        {
          paramavhr = paramavhr.iterator();
          while (paramavhr.hasNext())
          {
            localObject1 = (avhs)paramavhr.next();
            localObject3 = ((avhs)localObject1).a();
            localObject2 = ((avhs)localObject1).a();
            if (((avhs)localObject1).a() == 7)
            {
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                paramQQCustomDialog.setTitle((String)localObject1);
              }
            }
            else
            {
              if (((avhs)localObject1).a() != 8) {
                break label438;
              }
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(1));
              if ((localObject2 != null) && (((List)localObject2).size() != 0))
              {
                localObject1 = new SpannableStringBuilder();
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  Object localObject4 = (avhs)((Iterator)localObject2).next();
                  localObject3 = ((avhs)localObject4).a();
                  String str1;
                  if (((avhs)localObject4).a() == 2)
                  {
                    if (localObject3 != null)
                    {
                      localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                      str1 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                      localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                      if (!TextUtils.isEmpty((CharSequence)localObject4))
                      {
                        localObject3 = new SpannableString((CharSequence)localObject4);
                        ((SpannableString)localObject3).setSpan(Integer.valueOf(Color.parseColor("#03081A")), 0, ((SpannableString)localObject3).length(), 33);
                        ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
                      }
                    }
                  }
                  else if ((((avhs)localObject4).a() == 3) && (localObject3 != null))
                  {
                    localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                    str1 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
                    String str2 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                    localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                    SpannableString localSpannableString = new SpannableString((CharSequence)localObject4);
                    localSpannableString.setSpan(new baip(this, str1, (String)localObject3, str2), 0, ((String)localObject4).length(), 33);
                    ((SpannableStringBuilder)localObject1).append(localSpannableString);
                  }
                }
                paramQQCustomDialog.setMessageWithoutAutoLink((CharSequence)localObject1);
              }
            }
          }
        }
      }
    } while ((((avhs)localObject1).a() != 9) || (localObject2 == null));
    Object localObject1 = ((List)localObject2).iterator();
    int i = 0;
    label465:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (avhs)((Iterator)localObject1).next();
      if (((avhs)localObject2).a() != 10) {
        break label590;
      }
      localObject3 = ((avhs)localObject2).a();
      localObject2 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
      localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
      if (i != 0) {
        break label564;
      }
      paramQQCustomDialog.setNegativeButton((String)localObject2, new baiq(this, (String)localObject3, paramPushDialogTemplate));
    }
    label555:
    label564:
    label590:
    label591:
    for (;;)
    {
      i += 1;
      for (;;)
      {
        break label465;
        break;
        if (i != 1) {
          break label591;
        }
        paramQQCustomDialog.setPositiveButton((String)localObject2, new bair(this, (String)localObject3));
        break label555;
      }
    }
  }
  
  private void b(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 102) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)) {
      bait.a().b(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramPushDialogTemplate);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  public void a()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
      if (TextUtils.isEmpty(str)) {}
    }
    try
    {
      a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, Long.valueOf(str).longValue());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AIOPushDialogHelper", 1, "db search error: ", localException);
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 11: 
      do
      {
        return;
        this.jdField_a_of_type_Int = 11;
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return;
    case 5: 
      this.jdField_a_of_type_Int = 5;
      return;
    }
    a();
  }
  
  public void a(PushDialogTemplate paramPushDialogTemplate, int paramInt1, int paramInt2)
  {
    avhr localavhr;
    if ((paramPushDialogTemplate != null) && (paramPushDialogTemplate.templ_content != null))
    {
      localavhr = a(paramPushDialogTemplate.templ_content);
      if (localavhr != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
          break label217;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 2131755829);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setContentView(2131559043);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCanceledOnTouchOutside(false);
        LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.findViewById(2131363664);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
        localLayoutParams.leftMargin = DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 30.0F);
        localLayoutParams.rightMargin = DisplayUtil.dip2px(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext, 30.0F);
        localLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, localavhr, paramPushDialogTemplate);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      if (this.jdField_a_of_type_Int != 5) {
        break label267;
      }
      a(paramPushDialogTemplate, paramInt2);
      if (!paramPushDialogTemplate.isFriendBanned()) {
        break;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "dc00898", "", "", "0X800A4B9", "0X800A4B9", 0, 0, "", "", "", "");
      return;
      label217:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "dc00898", "", "", "0X800A4B8", "0X800A4B8", 0, 0, "", "", "", "");
    return;
    label267:
    b(paramPushDialogTemplate, paramInt1);
  }
  
  public void a(List<PushDialogTemplate> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        a((PushDialogTemplate)paramList.get(i), paramInt1, paramInt2);
        i += 1;
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 11, 5, 8 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bain
 * JD-Core Version:    0.7.0.1
 */