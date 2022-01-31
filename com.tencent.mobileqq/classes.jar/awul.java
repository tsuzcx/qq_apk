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

public class awul
  implements afal
{
  private int jdField_a_of_type_Int = 10;
  private awbw jdField_a_of_type_Awbw;
  public bdfq a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public awul(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie != null) {
      this.jdField_a_of_type_Awbw = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getEntityManagerFactory().createEntityManager();
    }
  }
  
  private aslh a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = aslq.a(new String(paramArrayOfByte, "utf-8"));
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private void a(awbw paramawbw, long paramLong)
  {
    awur.a().a(paramawbw, paramLong, new awum(this));
  }
  
  private void a(bdfq parambdfq, aslh paramaslh, PushDialogTemplate paramPushDialogTemplate)
  {
    paramaslh = paramaslh.a();
    if (paramaslh.a() != 6) {}
    Object localObject3;
    Object localObject2;
    label438:
    do
    {
      return;
      for (;;)
      {
        paramaslh = paramaslh.a();
        if ((paramaslh != null) && (paramaslh.size() != 0))
        {
          paramaslh = paramaslh.iterator();
          while (paramaslh.hasNext())
          {
            localObject1 = (asli)paramaslh.next();
            localObject3 = ((asli)localObject1).a();
            localObject2 = ((asli)localObject1).a();
            if (((asli)localObject1).a() == 7)
            {
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                parambdfq.setTitle((String)localObject1);
              }
            }
            else
            {
              if (((asli)localObject1).a() != 8) {
                break label438;
              }
              localObject1 = (String)((HashMap)localObject3).get(Integer.valueOf(1));
              if ((localObject2 != null) && (((List)localObject2).size() != 0))
              {
                localObject1 = new SpannableStringBuilder();
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  Object localObject4 = (asli)((Iterator)localObject2).next();
                  localObject3 = ((asli)localObject4).a();
                  String str1;
                  if (((asli)localObject4).a() == 2)
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
                  else if ((((asli)localObject4).a() == 3) && (localObject3 != null))
                  {
                    localObject4 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
                    str1 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
                    String str2 = (String)((HashMap)localObject3).get(Integer.valueOf(3));
                    localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(5));
                    SpannableString localSpannableString = new SpannableString((CharSequence)localObject4);
                    localSpannableString.setSpan(new awun(this, str1, (String)localObject3, str2), 0, ((String)localObject4).length(), 33);
                    ((SpannableStringBuilder)localObject1).append(localSpannableString);
                  }
                }
                parambdfq.setMessageWithoutAutoLink((CharSequence)localObject1);
              }
            }
          }
        }
      }
    } while ((((asli)localObject1).a() != 9) || (localObject2 == null));
    Object localObject1 = ((List)localObject2).iterator();
    int i = 0;
    label465:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (asli)((Iterator)localObject1).next();
      if (((asli)localObject2).a() != 10) {
        break label590;
      }
      localObject3 = ((asli)localObject2).a();
      localObject2 = (String)((HashMap)localObject3).get(Integer.valueOf(2));
      localObject3 = (String)((HashMap)localObject3).get(Integer.valueOf(4));
      if (i != 0) {
        break label564;
      }
      parambdfq.setNegativeButton((String)localObject2, new awuo(this, (String)localObject3, paramPushDialogTemplate));
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
        parambdfq.setPositiveButton((String)localObject2, new awup(this, (String)localObject3));
        break label555;
      }
    }
  }
  
  private void a(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 103) && (this.jdField_a_of_type_Awbw != null)) {
      awur.a().a(this.jdField_a_of_type_Awbw, paramPushDialogTemplate);
    }
  }
  
  private void b(PushDialogTemplate paramPushDialogTemplate, int paramInt)
  {
    if ((paramInt == 102) && (this.jdField_a_of_type_Awbw != null)) {
      awur.a().b(this.jdField_a_of_type_Awbw, paramPushDialogTemplate);
    }
    if (this.jdField_a_of_type_Bdfq != null) {
      this.jdField_a_of_type_Bdfq.dismiss();
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
      a(this.jdField_a_of_type_Awbw, Long.valueOf(str).longValue());
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
      } while (this.jdField_a_of_type_Bdfq == null);
      this.jdField_a_of_type_Bdfq.dismiss();
      return;
    case 3: 
      this.jdField_a_of_type_Int = 3;
      return;
    }
    a();
  }
  
  public void a(PushDialogTemplate paramPushDialogTemplate, int paramInt1, int paramInt2)
  {
    aslh localaslh;
    if ((paramPushDialogTemplate != null) && (paramPushDialogTemplate.templ_content != null))
    {
      localaslh = a(paramPushDialogTemplate.templ_content);
      if (localaslh != null)
      {
        if (this.jdField_a_of_type_Bdfq != null) {
          break label217;
        }
        this.jdField_a_of_type_Bdfq = new bdfq(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 2131755801);
        this.jdField_a_of_type_Bdfq.setContentView(2131558943);
        this.jdField_a_of_type_Bdfq.setCanceledOnTouchOutside(false);
        LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_Bdfq.findViewById(2131363352);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
        localLayoutParams.leftMargin = bcwh.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 30.0F);
        localLayoutParams.rightMargin = bcwh.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext, 30.0F);
        localLinearLayout.setLayoutParams(localLayoutParams);
      }
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Bdfq, localaslh, paramPushDialogTemplate);
      this.jdField_a_of_type_Bdfq.show();
      if (this.jdField_a_of_type_Int != 3) {
        break label267;
      }
      a(paramPushDialogTemplate, paramInt2);
      if (!paramPushDialogTemplate.isFriendBanned()) {
        break;
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", "", "0X800A4B9", "0X800A4B9", 0, 0, "", "", "", "");
      return;
      label217:
      this.jdField_a_of_type_Bdfq.dismiss();
    }
    azmj.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", "", "0X800A4B8", "0X800A4B8", 0, 0, "", "", "", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awul
 * JD-Core Version:    0.7.0.1
 */