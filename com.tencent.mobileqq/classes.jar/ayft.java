import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.1;
import com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.4;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ayft
  extends bbjq
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private aydz jdField_a_of_type_Aydz;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  private TextView c;
  private TextView d;
  private TextView e;
  
  public ayft(Context paramContext)
  {
    super(paramContext);
    if ((paramContext instanceof QQBrowserActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)paramContext);
      this.jdField_a_of_type_ComTencentSmttSdkWebView = ((QQBrowserActivity)paramContext).a();
    }
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b() != null))
    {
      this.jdField_a_of_type_Aydz = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.b().a().a();
      paramView = (RelativeLayout)paramView.findViewById(2131362878);
      if ((this.jdField_a_of_type_Aydz == null) || (!this.jdField_a_of_type_Aydz.jdField_a_of_type_Boolean)) {
        break label372;
      }
      paramView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378063));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new ayfu(this));
      if (this.jdField_a_of_type_Aydz.jdField_c_of_type_Int != 1) {
        break label269;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131690281));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131375560));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378063));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378061));
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#000000"));
      if (this.jdField_a_of_type_Aydz.jdField_c_of_type_Int == 2) {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#fe6c6c"));
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aydz.jdField_a_of_type_JavaLangString);
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378062));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368503));
      if (2 != this.jdField_a_of_type_Aydz.jdField_c_of_type_Int) {
        break label322;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aydz.b)) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
      label269:
      if (this.jdField_a_of_type_Aydz.jdField_c_of_type_Int == 2) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getText(2131689779));
      }
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Aydz.b);
    return;
    label322:
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aydz.f))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    a(this.jdField_a_of_type_Aydz.f, this.jdField_a_of_type_Aydz.jdField_d_of_type_Int);
    return;
    label372:
    paramView.setVisibility(8);
  }
  
  protected View a()
  {
    View localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131562494, null);
    a(localView);
    this.jdField_a_of_type_Bbjw.a((RelativeLayout)localView.findViewById(2131362136));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131361918));
    Object localObject2;
    Object localObject1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_a_of_type_JavaLangCharSequence != null) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375664));
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView = ((ElasticHorScrView)localView.findViewById(2131375665));
      localObject2 = a();
      if (localObject2.length <= 0) {
        break label396;
      }
      localObject1 = localObject2[0];
      label128:
      if (!((List)localObject1).isEmpty()) {
        break label959;
      }
    }
    label153:
    label948:
    label951:
    label954:
    label959:
    for (int j = 0;; j = 1)
    {
      if (localObject2.length > 1)
      {
        localObject2 = localObject2[1];
        if (!((List)localObject2).isEmpty()) {
          break label954;
        }
      }
      for (int k = 0;; k = 1)
      {
        Object localObject3 = new TextPaint();
        ((TextPaint)localObject3).setTextSize(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298815));
        Object localObject4 = new StaticLayout(a((TextPaint)localObject3, this.jdField_e_of_type_Int, a((List)localObject1), 5), (TextPaint)localObject3, this.jdField_e_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        StaticLayout localStaticLayout = new StaticLayout(a((TextPaint)localObject3, this.jdField_e_of_type_Int, a((List)localObject2), 5), (TextPaint)localObject3, this.jdField_e_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, this.g, true);
        localObject3 = localStaticLayout;
        if (((StaticLayout)localObject4).getHeight() >= localStaticLayout.getHeight()) {
          localObject3 = localObject4;
        }
        int m = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131296668);
        int i;
        if (j != 0)
        {
          this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367168));
          if (Build.VERSION.SDK_INT >= 9) {
            this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
          }
          localObject4 = ((List)localObject1).iterator();
          i = 0;
          label356:
          if (((Iterator)localObject4).hasNext())
          {
            if (((bbjs)((Iterator)localObject4).next()).jdField_d_of_type_Int != 0) {
              break label951;
            }
            i += 1;
          }
        }
        for (;;)
        {
          break label356;
          f();
          break;
          localObject1 = new ArrayList(0);
          break label128;
          localObject2 = new ArrayList(0);
          break label153;
          int n = this.jdField_d_of_type_Int + a() + this.jdField_d_of_type_Int;
          this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(n);
          this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
          localObject4 = this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
          this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
          ((ViewGroup.LayoutParams)localObject4).width = (n * i + this.h + this.h);
          this.jdField_a_of_type_Int = ((ViewGroup.LayoutParams)localObject4).width;
          ((ViewGroup.LayoutParams)localObject4).height = (this.jdField_c_of_type_Int + this.f + ((StaticLayout)localObject3).getHeight() + m);
          this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
          this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(new bbjt(this.jdField_a_of_type_AndroidContentContext, (List)localObject1));
          this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
          this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
          if (k != 0)
          {
            this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)localView.findViewById(2131367169));
            if (Build.VERSION.SDK_INT >= 9) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setOverScrollMode(2);
            }
            this.jdField_b_of_type_AndroidWidgetGridView.setSmoothScrollbarEnabled(false);
            localObject1 = ((List)localObject2).iterator();
            i = 0;
            if (((Iterator)localObject1).hasNext())
            {
              if (((bbjs)((Iterator)localObject1).next()).jdField_d_of_type_Int != 0) {
                break label948;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break;
            n = this.jdField_d_of_type_Int + a() + this.jdField_d_of_type_Int;
            this.jdField_b_of_type_AndroidWidgetGridView.setColumnWidth(n);
            this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
            localObject1 = this.jdField_b_of_type_AndroidWidgetGridView.getLayoutParams();
            this.jdField_b_of_type_AndroidWidgetGridView.setPadding(this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingTop(), this.h, this.jdField_b_of_type_AndroidWidgetGridView.getPaddingBottom());
            ((ViewGroup.LayoutParams)localObject1).width = (n * i + this.h + this.h);
            this.jdField_b_of_type_Int = ((ViewGroup.LayoutParams)localObject1).width;
            ((ViewGroup.LayoutParams)localObject1).height = (this.jdField_c_of_type_Int + this.f + ((StaticLayout)localObject3).getHeight() + m);
            this.jdField_b_of_type_AndroidWidgetGridView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_b_of_type_AndroidWidgetGridView.setNumColumns(i);
            this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(new bbjt(this.jdField_a_of_type_AndroidContentContext, (List)localObject2));
            this.jdField_b_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
            this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_AndroidWidgetAdapterView$OnItemClickListener);
            localObject1 = (TextView)localView.findViewById(2131361911);
            ((TextView)localObject1).setText(2131690596);
            ((TextView)localObject1).setOnClickListener(new ayfv(this));
            if (j == 0) {
              this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            if (k == 0) {
              this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setVisibility(8);
            }
            localView.post(new TeamWorkShareActionSheetBuilder.4(this));
            return localView;
          }
        }
      }
    }
  }
  
  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super.a(paramOnItemClickListener);
  }
  
  public void a(bcvg parambcvg)
  {
    super.a(new ayfw(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo, parambcvg));
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = this.jdField_a_of_type_Aydz.g;
    if (paramInt == 0)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getString(2131720114));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new TeamWorkShareActionSheetBuilder.1(this, paramString, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayft
 * JD-Core Version:    0.7.0.1
 */