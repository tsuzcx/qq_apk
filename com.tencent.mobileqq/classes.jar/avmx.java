import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;

public class avmx
  extends avoj
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private DiscussionMemberInfo jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public avmx(QQAppInterface paramQQAppInterface, int paramInt, DiscussionMemberInfo paramDiscussionMemberInfo)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo = paramDiscussionMemberInfo;
  }
  
  private void a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_JavaLangString = "";
      return;
    case 0: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
        return;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      this.jdField_b_of_type_JavaLangString = null;
      return;
    case 2: 
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName))
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
        return;
      }
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
      return;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
  
  protected long a(String paramString)
  {
    DiscussionInfo localDiscussionInfo = ((ajhh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin);
    if ((localDiscussionInfo == null) || (localDiscussionInfo.isDiscussHrMeeting()) || (localDiscussionInfo.isHidden()))
    {
      this.jdField_a_of_type_Long = -9223372036854775808L;
      return this.jdField_a_of_type_Long;
    }
    this.c = paramString;
    this.jdField_a_of_type_Long = -9223372036854775808L;
    long l = avwf.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, avin.k);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 2;
    }
    l = avwf.b(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, avin.l);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 1;
    }
    l = avwf.a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, avin.o, false);
    if (l > this.jdField_a_of_type_Long)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Int = 0;
    }
    if (this.jdField_a_of_type_Long != -9223372036854775808L)
    {
      this.jdField_a_of_type_Long += avin.H;
      a();
    }
    return this.jdField_a_of_type_Long;
  }
  
  public Pair<CharSequence, CharSequence> a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, avwf.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName)) {
        return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, avwf.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false));
      }
      return new Pair(avwf.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.c, 6, false), null);
    case 2: 
      return new Pair(avwf.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, this.c, 6, true), null);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
      return new Pair(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark, avwf.c(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, this.c, 6, true));
    }
    return new Pair(avwf.b(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, this.c, 6, true), null);
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (avwf.a(this.jdField_b_of_type_Int))
    {
      ahcq.a = true;
      ahcq.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin, 1004, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberName, false);
      avwf.a(this.c, 20, 1, paramView);
      ajrs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c);
      avwf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().toString(), this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin, this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin, 1004);
      avwf.a(this.c, 20, paramView, false);
      avwf.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        avwf.a("search", "contact", "contacts", 0, 0, new String[] { avwf.a(this.jdField_b_of_type_Int) });
      }
      if (((a() instanceof String)) && (!this.jdField_b_of_type_Boolean)) {
        avwf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.c, this.i, (String)a(), e());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.i != null) && (!TextUtils.isEmpty(this.i))) {
          avsv.a(null, 0, this.jdField_b_of_type_Int, "0X8009D31", 1, 0, null, null);
        }
      }
      else {
        return;
      }
      avsv.a(null, 0, this.jdField_b_of_type_Int, "0X8009D37", 0, 0, null, null);
      return;
    }
    avwf.a(paramView, this);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.memberUin;
  }
  
  public int c()
  {
    return 1;
  }
  
  public CharSequence c()
  {
    if (avwf.a(this.jdField_b_of_type_Int)) {
      return ajjy.a(2131636775);
    }
    return ajjy.a(2131636736);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public int d()
  {
    return 1004;
  }
  
  public CharSequence d()
  {
    return null;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public int e()
  {
    return 1;
  }
  
  public CharSequence e()
  {
    Object localObject = a();
    CharSequence localCharSequence = b();
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      localObject = super.e();
      SpannableStringBuilder localSpannableStringBuilder;
      do
      {
        return localObject;
        localSpannableStringBuilder = new SpannableStringBuilder();
        if (localObject != null) {
          localSpannableStringBuilder.append((CharSequence)localObject);
        }
        localObject = localSpannableStringBuilder;
      } while (localCharSequence == null);
      localSpannableStringBuilder.append(localCharSequence);
      return localSpannableStringBuilder;
      return localObject;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.inteRemark)) {
        return localObject;
      }
    } while ((localCharSequence == null) || (localCharSequence.length() <= 2));
    return localCharSequence.subSequence(1, localCharSequence.length() - 1);
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataDiscussionMemberInfo.discussionUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmx
 * JD-Core Version:    0.7.0.1
 */