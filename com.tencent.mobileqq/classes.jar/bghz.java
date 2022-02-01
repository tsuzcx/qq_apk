import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1;
import com.tencent.qphone.base.util.QLog;
import java.text.MessageFormat;

public class bghz
  extends ClickableSpan
  implements bkzq
{
  private final Context jdField_a_of_type_AndroidContentContext;
  private final bghy jdField_a_of_type_Bghy;
  private bkzi jdField_a_of_type_Bkzi;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public bghz(QQAppInterface paramQQAppInterface, Context paramContext, bghy parambghy)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bghy = parambghy;
    a("Grp_edu", "", "Grp_AIO", "GuideWords_Show", 0, 0);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Bkzi != null) && (this.jdField_a_of_type_Bkzi.isShowing())) {
      this.jdField_a_of_type_Bkzi.dismiss();
    }
    this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this.jdField_a_of_type_AndroidContentContext, null));
    Object localObject2 = this.jdField_a_of_type_Bghy.b();
    Object localObject1 = localObject2;
    if (((String)localObject2).length() > 10) {
      localObject1 = ((String)localObject2).substring(0, 5) + "…" + ((String)localObject2).substring(((String)localObject2).length() - 5, ((String)localObject2).length());
    }
    localObject1 = MessageFormat.format(bghx.a()[this.jdField_a_of_type_Bghy.jdField_b_of_type_Int], new Object[] { localObject1 });
    localObject2 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558441, null);
    ((View)localObject2).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837572));
    ((View)localObject2).setOnClickListener(new bgia(this));
    TextView localTextView = (TextView)((View)localObject2).findViewById(2131361985);
    localTextView.setVisibility(0);
    localTextView.setText((CharSequence)localObject1);
    localTextView.setContentDescription((CharSequence)localObject1);
    localTextView.setGravity(17);
    localTextView.setPadding(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0, UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F), 0);
    this.jdField_a_of_type_Bkzi.b((View)localObject2);
    this.jdField_a_of_type_Bkzi.c(bghx.b()[this.jdField_a_of_type_Bghy.jdField_b_of_type_Int]);
    this.jdField_a_of_type_Bkzi.d(anvx.a(2131713027));
    this.jdField_a_of_type_Bkzi.a(this);
    this.jdField_a_of_type_Bkzi.show();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    ThreadManager.excute(new SchoolTroopKeywordManager.SchoolTroopHighlightSpan.1(this, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2), 32, null, true);
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    Object localObject;
    bgld localbgld;
    if (paramInt == 0)
    {
      localObject = null;
      localbgld = bgld.a();
      if (this.jdField_a_of_type_Bghy.jdField_b_of_type_Int != 1) {
        break label201;
      }
      paramView = localbgld.a("troop_homework_create_notice");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        localObject = new bgle();
        ((bgle)localObject).a = this.jdField_a_of_type_Bghy.a;
        ((bgle)localObject).c = "aio_keyword";
        ((bgle)localObject).h = this.jdField_a_of_type_Bghy.jdField_b_of_type_JavaLangString;
        ((bgle)localObject).i = this.jdField_a_of_type_Bghy.b();
        paramView = localbgld.a(paramView, (bgle)localObject);
        if (QLog.isDevelopLevel()) {
          QLog.i(bghx.a, 2, "do action '" + this.jdField_a_of_type_Bghy.jdField_b_of_type_Int + "', open url: " + paramView);
        }
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
      a("Grp_edu", "", "Grp_AIO", "GuideActionsheet_Clk", 0, 0);
      if (this.jdField_a_of_type_Bkzi != null) {
        this.jdField_a_of_type_Bkzi.dismiss();
      }
      return;
      label201:
      if (this.jdField_a_of_type_Bghy.jdField_b_of_type_Int == 2)
      {
        paramView = localbgld.a("troop_create_homework");
      }
      else
      {
        paramView = (View)localObject;
        if (QLog.isColorLevel())
        {
          QLog.e(bghx.a, 2, "I don't know this action '" + this.jdField_a_of_type_Bghy.jdField_b_of_type_Int + "'");
          paramView = (View)localObject;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (bhcw.a)
    {
      if (QLog.isColorLevel()) {
        QLog.e(bghx.a, 2, "SchoolTroopHighlightSpan onCLick is invoked by LongClick misstake");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghz
 * JD-Core Version:    0.7.0.1
 */