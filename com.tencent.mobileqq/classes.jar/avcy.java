import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pushdialog.PushDialogTemplate;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class avcy
  implements adif
{
  private int jdField_a_of_type_Int = 10;
  private aukp jdField_a_of_type_Aukp;
  public bbgu a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public avcy(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie != null) {
      this.jdField_a_of_type_Aukp = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getEntityManagerFactory().createEntityManager();
    }
  }
  
  private aqut a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = aqvc.a(new String(paramArrayOfByte, "utf-8"));
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private void a(aukp paramaukp, long paramLong)
  {
    avde.a().a(paramaukp, paramLong, new avcz(this));
  }
  
  private void a(bbgu parambbgu, aqut paramaqut, PushDialogTemplate paramPushDialogTemplate)
  {
    paramaqut = paramaqut.a();
    if (paramaqut.a() != 6) {}
    Object localObject3;
    Object localObject2;
    label438:
    do
    {
      return;
      for (;;)
      {
        paramaqut = paramaqut.a();
        if ((paramaqut != null) && (paramaqut.size() != 0))
        {
          paramaqut = paramaqut.iterator();
          while (paramaqut.hasNext())
          {
            localObject1 = (aquu)paramaqut.next();
            localObject3 = ((aquu)localObject1).a();
            localObject2 = ((aquu)localObject1).a();
            if (((aquu)localObject1).a() == 7)
            {
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                parambbgu.setTitle((String)localObject1);
              }
            }
            else
            {
              if (((aquu)localObject1).a() != 8) {
                break label438;
              }
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(1));
              if ((localObject2 != null) && (((List)localObject2).size() != 0))
              {
                localObject1 = new SpannableStringBuilder();
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  Object localObject4 = (aquu)((Iterator)localObject2).next();
                  localObject3 = ((aquu)localObject4).a();
                  String str1;
                  if (((aquu)localObject4).a() == 2)
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
                  else if ((((aquu)localObject4).a() == 3) && (localObject3 != null))
                  {
                    localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                    str1 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
                    String str2 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                    localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                    SpannableString localSpannableString = new SpannableString((CharSequence)localObject4);
                    localSpannableString.setSpan(new avda(this, str1, (String)localObject3, str2), 0, ((String)localObject4).length(), 33);
                    ((SpannableStringBuilder)localObject1).append(localSpannableString);
                  }
                }
                parambbgu.setMessageWithoutAutoLink((CharSequence)localObject1);
              }
            }
          }
        }
      }
    } while ((((aquu)localObject1).a() != 9) || (localObject2 == null));
    Object localObject1 = ((List)localObject2).iterator();
    int i = 0;
    label465:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (aquu)((Iterator)localObject1).next();
      if (((aquu)localObject2).a() != 10) {
        break label590;
      }
      localObject3 = ((aquu)localObject2).a();
      localObject2 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
      localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
      if (i != 0) {
        break label564;
      }
      parambbgu.setNegativeButton((String)localObject2, new avdb(this, (String)localObject3, paramPushDialogTemplate));
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
        parambbgu.setPositiveButton((String)localObject2, new avdc(this, (String)localObject3));
        break label555;
      }
    }
  }
  
  private void a(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 103) && (this.jdField_a_of_type_Aukp != null)) {
      avde.a().a(this.jdField_a_of_type_Aukp, paramPushDialogTemplate);
    }
  }
  
  private void b(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 102) && (this.jdField_a_of_type_Aukp != null)) {
      avde.a().b(this.jdField_a_of_type_Aukp, paramPushDialogTemplate);
    }
    if (this.jdField_a_of_type_Bbgu != null) {
      this.jdField_a_of_type_Bbgu.dismiss();
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
      a(this.jdField_a_of_type_Aukp, Long.valueOf(str).longValue());
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
    case 9: 
      do
      {
        return;
        this.jdField_a_of_type_Int = 9;
      } while (this.jdField_a_of_type_Bbgu == null);
      this.jdField_a_of_type_Bbgu.dismiss();
      return;
    case 3: 
      this.jdField_a_of_type_Int = 3;
      return;
    }
    a();
  }
  
  public void a(PushDialogTemplate paramPushDialogTemplate, int paramInt1, int paramInt2)
  {
    aqut localaqut;
    if ((paramPushDialogTemplate != null) && (paramPushDialogTemplate.templ_content != null))
    {
      localaqut = a(paramPushDialogTemplate.templ_content);
      if (localaqut != null)
      {
        if (this.jdField_a_of_type_Bbgu != null) {
          break label217;
        }
        this.jdField_a_of_type_Bbgu = new bbgu(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131755791);
        this.jdField_a_of_type_Bbgu.setContentView(2131558906);
        this.jdField_a_of_type_Bbgu.setCanceledOnTouchOutside(false);
        LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bbgu.findViewById(2131363314);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
        localLayoutParams.leftMargin = baxn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 30.0F);
        localLayoutParams.rightMargin = baxn.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 30.0F);
        localLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bbgu, localaqut, paramPushDialogTemplate);
      this.jdField_a_of_type_Bbgu.show();
      if (this.jdField_a_of_type_Int != 3) {
        break label267;
      }
      a(paramPushDialogTemplate, paramInt2);
      if (!paramPushDialogTemplate.isFriendBanned()) {
        break;
      }
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", "", "0X800A4B9", "0X800A4B9", 0, 0, "", "", "", "");
      return;
      label217:
      this.jdField_a_of_type_Bbgu.dismiss();
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", "", "0X800A4B8", "0X800A4B8", 0, 0, "", "", "", "");
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
    return new int[] { 9, 3, 6 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avcy
 * JD-Core Version:    0.7.0.1
 */