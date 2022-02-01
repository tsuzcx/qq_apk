import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bamz
  implements agvc
{
  private int jdField_a_of_type_Int = 12;
  public bhpc a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  public bamz(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a().createEntityManager();
    }
  }
  
  private avov a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = avpe.a(new String(paramArrayOfByte, "utf-8"));
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private void a(bhpc parambhpc, avov paramavov, PushDialogTemplate paramPushDialogTemplate)
  {
    paramavov = paramavov.a();
    if (paramavov.a() != 6) {}
    Object localObject3;
    Object localObject2;
    label438:
    do
    {
      return;
      for (;;)
      {
        paramavov = paramavov.a();
        if ((paramavov != null) && (paramavov.size() != 0))
        {
          paramavov = paramavov.iterator();
          while (paramavov.hasNext())
          {
            localObject1 = (avow)paramavov.next();
            localObject3 = ((avow)localObject1).a();
            localObject2 = ((avow)localObject1).a();
            if (((avow)localObject1).a() == 7)
            {
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                parambhpc.setTitle((String)localObject1);
              }
            }
            else
            {
              if (((avow)localObject1).a() != 8) {
                break label438;
              }
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(1));
              if ((localObject2 != null) && (((List)localObject2).size() != 0))
              {
                localObject1 = new SpannableStringBuilder();
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  Object localObject4 = (avow)((Iterator)localObject2).next();
                  localObject3 = ((avow)localObject4).a();
                  String str1;
                  if (((avow)localObject4).a() == 2)
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
                  else if ((((avow)localObject4).a() == 3) && (localObject3 != null))
                  {
                    localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                    str1 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
                    String str2 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                    localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                    SpannableString localSpannableString = new SpannableString((CharSequence)localObject4);
                    localSpannableString.setSpan(new banb(this, str1, (String)localObject3, str2), 0, ((String)localObject4).length(), 33);
                    ((SpannableStringBuilder)localObject1).append(localSpannableString);
                  }
                }
                parambhpc.setMessageWithoutAutoLink((CharSequence)localObject1);
              }
            }
          }
        }
      }
    } while ((((avow)localObject1).a() != 9) || (localObject2 == null));
    Object localObject1 = ((List)localObject2).iterator();
    int i = 0;
    label465:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (avow)((Iterator)localObject1).next();
      if (((avow)localObject2).a() != 10) {
        break label590;
      }
      localObject3 = ((avow)localObject2).a();
      localObject2 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
      localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
      if (i != 0) {
        break label564;
      }
      parambhpc.setNegativeButton((String)localObject2, new banc(this, (String)localObject3, paramPushDialogTemplate));
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
        parambhpc.setPositiveButton((String)localObject2, new band(this, (String)localObject3));
        break label555;
      }
    }
  }
  
  private void a(EntityManager paramEntityManager, long paramLong)
  {
    banf.a().a(paramEntityManager, paramLong, new bana(this));
  }
  
  private void a(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 103) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)) {
      banf.a().a(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramPushDialogTemplate);
    }
  }
  
  private void b(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 102) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null)) {
      banf.a().b(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, paramPushDialogTemplate);
    }
    if (this.jdField_a_of_type_Bhpc != null) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
  }
  
  public void a()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
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
    case 10: 
      do
      {
        return;
        this.jdField_a_of_type_Int = 10;
      } while (this.jdField_a_of_type_Bhpc == null);
      this.jdField_a_of_type_Bhpc.dismiss();
      return;
    case 4: 
      this.jdField_a_of_type_Int = 4;
      return;
    }
    a();
  }
  
  public void a(PushDialogTemplate paramPushDialogTemplate, int paramInt1, int paramInt2)
  {
    avov localavov;
    if ((paramPushDialogTemplate != null) && (paramPushDialogTemplate.templ_content != null))
    {
      localavov = a(paramPushDialogTemplate.templ_content);
      if (localavov != null)
      {
        if (this.jdField_a_of_type_Bhpc != null) {
          break label217;
        }
        this.jdField_a_of_type_Bhpc = new bhpc(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131755824);
        this.jdField_a_of_type_Bhpc.setContentView(2131559008);
        this.jdField_a_of_type_Bhpc.setCanceledOnTouchOutside(false);
        LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bhpc.findViewById(2131363566);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
        localLayoutParams.leftMargin = bhgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 30.0F);
        localLayoutParams.rightMargin = bhgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 30.0F);
        localLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bhpc, localavov, paramPushDialogTemplate);
      this.jdField_a_of_type_Bhpc.show();
      if (this.jdField_a_of_type_Int != 4) {
        break label267;
      }
      a(paramPushDialogTemplate, paramInt2);
      if (!paramPushDialogTemplate.isFriendBanned()) {
        break;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", "", "0X800A4B9", "0X800A4B9", 0, 0, "", "", "", "");
      return;
      label217:
      this.jdField_a_of_type_Bhpc.dismiss();
    }
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", "", "0X800A4B8", "0X800A4B8", 0, 0, "", "", "", "");
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
    return new int[] { 10, 4, 7 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamz
 * JD-Core Version:    0.7.0.1
 */