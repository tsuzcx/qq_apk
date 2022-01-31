import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1;
import com.tencent.qphone.base.util.QLog;
import java.text.MessageFormat;

public class baie
  extends ClickableSpan
  implements bfoq
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final baid jdField_a_of_type_Baid;
  private bfol jdField_a_of_type_Bfol;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public baie(QQAppInterface paramQQAppInterface, Context paramContext, baid parambaid)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Baid = parambaid;
    a("Grp_edu", "", "Grp_AIO", "GuideWords_Show", 0, 0);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Bfol != null) && (this.jdField_a_of_type_Bfol.isShowing())) {
      this.jdField_a_of_type_Bfol.dismiss();
    }
    this.jdField_a_of_type_Bfol = ((bfol)bfoy.a(this.jdField_a_of_type_AndroidContentContext, null));
    Object localObject2 = this.jdField_a_of_type_Baid.b();
    Object localObject1 = localObject2;
    if (((String)localObject2).length() > 10) {
      localObject1 = ((String)localObject2).substring(0, 5) + "…" + ((String)localObject2).substring(((String)localObject2).length() - 5, ((String)localObject2).length());
    }
    localObject1 = MessageFormat.format(baic.a()[this.jdField_a_of_type_Baid.jdField_b_of_type_Int], new Object[] { localObject1 });
    localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558435, null);
    ((View)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837560));
    ((View)localObject2).setOnClickListener(new baif(this));
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131361927);
    localTextView.setVisibility(0);
    localTextView.setText((CharSequence)localObject1);
    localTextView.setContentDescription((CharSequence)localObject1);
    localTextView.setGravity(17);
    localTextView.setPadding(vzo.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, vzo.a(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
    this.jdField_a_of_type_Bfol.b((View)localObject2);
    this.jdField_a_of_type_Bfol.c(baic.b()[this.jdField_a_of_type_Baid.jdField_b_of_type_Int]);
    this.jdField_a_of_type_Bfol.d(ajyc.a(2131713565));
    this.jdField_a_of_type_Bfol.a(this);
    this.jdField_a_of_type_Bfol.show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    ThreadManager.excute(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1(this, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2), 32, null, true);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    Object localObject;
    bali localbali;
    if (paramInt == 0)
    {
      localObject = null;
      localbali = bali.a();
      if (this.jdField_a_of_type_Baid.jdField_b_of_type_Int != 1) {
        break label201;
      }
      paramView = localbali.a("troop_homework_create_notice");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        localObject = new balj();
        ((balj)localObject).a = this.jdField_a_of_type_Baid.a;
        ((balj)localObject).c = "aio_keyword";
        ((balj)localObject).h = this.jdField_a_of_type_Baid.jdField_b_of_type_JavaLangString;
        ((balj)localObject).i = this.jdField_a_of_type_Baid.b();
        paramView = localbali.a(paramView, (balj)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.i(baic.a, 2, "do action '" + this.jdField_a_of_type_Baid.jdField_b_of_type_Int + "', open url: " + paramView);
        }
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
      a("Grp_edu", "", "Grp_AIO", "GuideActionsheet_Clk", 0, 0);
      if (this.jdField_a_of_type_Bfol != null) {
        this.jdField_a_of_type_Bfol.dismiss();
      }
      return;
      label201:
      if (this.jdField_a_of_type_Baid.jdField_b_of_type_Int == 2)
      {
        paramView = localbali.a("troop_create_homework");
      }
      else
      {
        paramView = (View)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e(baic.a, 2, "I don't know this action '" + this.jdField_a_of_type_Baid.jdField_b_of_type_Int + "'");
          paramView = (View)localObject;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (bbcc.a)
    {
      if (QLog.isColorLevel()) {
        QLog.e(baic.a, 2, "SchoolTroopHighlightSpan onCLick is invoked by LongClick misstake");
      }
      return;
    }
    if ((paramView instanceof ETTextView)) {
      ((ETTextView)paramView).mHasClickedArkSpan = true;
    }
    a();
    a("Grp_edu", "", "Grp_AIO", "GuideWords_Clk", 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baie
 * JD-Core Version:    0.7.0.1
 */