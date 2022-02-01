import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.BusinessSearchEntryModel.2;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bbyh
  extends bbyg<View>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean b;
  
  public bbyh(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.b = paramBoolean;
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label97;
      }
    }
    label97:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131563027, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370347));
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365699));
    localArrayList.add(Integer.valueOf(2131365703));
    localArrayList.add(Integer.valueOf(2131365704));
    localArrayList.add(Integer.valueOf(2131365705));
    localArrayList.add(Integer.valueOf(2131365706));
    localArrayList.add(Integer.valueOf(2131365707));
    localArrayList.add(Integer.valueOf(2131365708));
    localArrayList.add(Integer.valueOf(2131365709));
    localArrayList.add(Integer.valueOf(2131365710));
    localArrayList.add(Integer.valueOf(2131365700));
    localArrayList.add(Integer.valueOf(2131365701));
    localArrayList.add(Integer.valueOf(2131365702));
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new bcdo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, this.jdField_a_of_type_Int, this.b)), 5, null, true);
  }
  
  public void a(bcgq parambcgq)
  {
    b(parambcgq);
  }
  
  public List<Integer> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365699));
    localArrayList.add(Integer.valueOf(2131365703));
    localArrayList.add(Integer.valueOf(2131365704));
    localArrayList.add(Integer.valueOf(2131365705));
    localArrayList.add(Integer.valueOf(2131365706));
    localArrayList.add(Integer.valueOf(2131365708));
    localArrayList.add(Integer.valueOf(2131365709));
    localArrayList.add(Integer.valueOf(2131365710));
    localArrayList.add(Integer.valueOf(2131365700));
    localArrayList.add(Integer.valueOf(2131365701));
    return localArrayList;
  }
  
  public void b(bcgq parambcgq)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    parambcgq = (bcdo)parambcgq;
    if (parambcgq == null) {}
    for (;;)
    {
      return;
      Object localObject1 = parambcgq.a;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        label78:
        int i;
        label80:
        bcdp localbcdp;
        View localView1;
        View localView2;
        Object localObject3;
        if (((List)localObject1).size() <= 6)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (((List)localObject1).size() != 10) {
            break label424;
          }
          parambcgq = b();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label463;
          }
          localbcdp = (bcdp)((List)localObject1).get(i);
          localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)parambcgq.get(i)).intValue());
          localView2 = localView1.findViewById(2131376435);
          TextView localTextView = (TextView)localView1.findViewById(2131365698);
          URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131365697);
          localView1.setVisibility(0);
          localObject3 = new ColorDrawable();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label432;
          }
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167328));
          label209:
          if (!TextUtils.isEmpty(localbcdp.jdField_b_of_type_JavaLangString))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mRequestWidth = AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
            localObject3 = URLDrawable.getDrawable(localbcdp.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
            if (localURLImageView != null) {
              localURLImageView.setImageDrawable((Drawable)localObject3);
            }
          }
          localTextView.setText(localbcdp.jdField_a_of_type_JavaLangString);
          int j = bhhr.a(localbcdp.c, (String)localObject2);
          boolean bool = bhhr.a(localbcdp.c, (String)localObject2);
          if ((localbcdp.jdField_a_of_type_Int != 1) || ((localbcdp.jdField_b_of_type_Int <= j) && ((localbcdp.jdField_b_of_type_Int != j) || (bool)))) {
            break label453;
          }
          localView2.setVisibility(0);
        }
        for (;;)
        {
          bhhr.a(localbcdp.c, localbcdp.jdField_b_of_type_Int, (String)localObject2);
          localView1.setOnClickListener(new bbyi(this, localView1, localbcdp, localView2, (String)localObject2, (List)localObject1));
          i += 1;
          break label80;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          break;
          label424:
          parambcgq = a();
          break label78;
          label432:
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167327));
          break label209;
          label453:
          localView2.setVisibility(8);
        }
        label463:
        if (((List)localObject1).size() < 6)
        {
          i = ((List)localObject1).size();
          while (i < 6)
          {
            this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)parambcgq.get(i)).intValue()).setVisibility(8);
            i += 1;
          }
        }
        if (((List)localObject1).size() == 6)
        {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365708).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365709).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365710).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365700).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365701).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365702).setVisibility(8);
          parambcgq = new StringBuilder("");
          i = 0;
          label630:
          if (i >= ((List)localObject1).size()) {
            break label751;
          }
          if (i != ((List)localObject1).size() - 1) {
            break label723;
          }
          parambcgq.append(((bcdp)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          i += 1;
          break label630;
          if (((List)localObject1).size() != 10) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365707).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365702).setVisibility(8);
          break;
          label723:
          parambcgq.append(((bcdp)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString).append("::");
        }
        label751:
        localObject2 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(3));
        if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue()))
        {
          bcnc.a("home_page", "exp_entry", new String[] { parambcgq.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
          bcjs.a(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(bcjs.a(this.jdField_a_of_type_Int)).ver4(parambcgq.toString()).ver7("{experiment_id:" + bcjs.jdField_b_of_type_JavaLangString + "}"));
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          new aogi((QQAppInterface)localObject2).b((QQAppInterface)localObject2, "exp_entry", "all_result", bcjs.a(this.jdField_a_of_type_Int), "", parambcgq.toString(), "{experiment_id:" + bcjs.jdField_b_of_type_JavaLangString + "}");
          SearchEntryFragment.mIsModelsReported.put(Integer.valueOf(3), Boolean.valueOf(true));
          i = SearchEntryFragment.a(this.jdField_a_of_type_Int);
          parambcgq = ((List)localObject1).iterator();
          while (parambcgq.hasNext())
          {
            localObject1 = (bcdp)parambcgq.next();
            if (localObject1 != null) {
              bcjs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, i, "0X8009D1B", 0, 0, ((bcdp)localObject1).jdField_a_of_type_JavaLangString, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyh
 * JD-Core Version:    0.7.0.1
 */