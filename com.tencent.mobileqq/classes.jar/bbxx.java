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

public class bbxx
  extends bbxw<View>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean b;
  
  public bbxx(int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131563072, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370191));
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365573));
    localArrayList.add(Integer.valueOf(2131365577));
    localArrayList.add(Integer.valueOf(2131365578));
    localArrayList.add(Integer.valueOf(2131365579));
    localArrayList.add(Integer.valueOf(2131365580));
    localArrayList.add(Integer.valueOf(2131365581));
    localArrayList.add(Integer.valueOf(2131365582));
    localArrayList.add(Integer.valueOf(2131365583));
    localArrayList.add(Integer.valueOf(2131365584));
    localArrayList.add(Integer.valueOf(2131365574));
    localArrayList.add(Integer.valueOf(2131365575));
    localArrayList.add(Integer.valueOf(2131365576));
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new bcdw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, this.jdField_a_of_type_Int, this.b)), 5, null, true);
  }
  
  public void a(bcgy parambcgy)
  {
    b(parambcgy);
  }
  
  public List<Integer> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365573));
    localArrayList.add(Integer.valueOf(2131365577));
    localArrayList.add(Integer.valueOf(2131365578));
    localArrayList.add(Integer.valueOf(2131365579));
    localArrayList.add(Integer.valueOf(2131365580));
    localArrayList.add(Integer.valueOf(2131365582));
    localArrayList.add(Integer.valueOf(2131365583));
    localArrayList.add(Integer.valueOf(2131365584));
    localArrayList.add(Integer.valueOf(2131365574));
    localArrayList.add(Integer.valueOf(2131365575));
    return localArrayList;
  }
  
  public void b(bcgy parambcgy)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    parambcgy = (bcdw)parambcgy;
    if (parambcgy == null) {}
    for (;;)
    {
      return;
      Object localObject1 = parambcgy.a;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        label78:
        int i;
        label80:
        bcdx localbcdx;
        View localView1;
        View localView2;
        Object localObject3;
        if (((List)localObject1).size() <= 6)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (((List)localObject1).size() != 10) {
            break label424;
          }
          parambcgy = b();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label463;
          }
          localbcdx = (bcdx)((List)localObject1).get(i);
          localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)parambcgy.get(i)).intValue());
          localView2 = localView1.findViewById(2131376418);
          TextView localTextView = (TextView)localView1.findViewById(2131365572);
          URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131365571);
          localView1.setVisibility(0);
          localObject3 = new ColorDrawable();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label432;
          }
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167277));
          label209:
          if (!TextUtils.isEmpty(localbcdx.jdField_b_of_type_JavaLangString))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = agej.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mRequestWidth = agej.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
            localObject3 = URLDrawable.getDrawable(localbcdx.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
            if (localURLImageView != null) {
              localURLImageView.setImageDrawable((Drawable)localObject3);
            }
          }
          localTextView.setText(localbcdx.jdField_a_of_type_JavaLangString);
          int j = bhsi.a(localbcdx.c, (String)localObject2);
          boolean bool = bhsi.a(localbcdx.c, (String)localObject2);
          if ((localbcdx.jdField_a_of_type_Int != 1) || ((localbcdx.jdField_b_of_type_Int <= j) && ((localbcdx.jdField_b_of_type_Int != j) || (bool)))) {
            break label453;
          }
          localView2.setVisibility(0);
        }
        for (;;)
        {
          bhsi.a(localbcdx.c, localbcdx.jdField_b_of_type_Int, (String)localObject2);
          localView1.setOnClickListener(new bbxy(this, localView1, localbcdx, localView2, (String)localObject2, (List)localObject1));
          i += 1;
          break label80;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          break;
          label424:
          parambcgy = a();
          break label78;
          label432:
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167276));
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
            this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)parambcgy.get(i)).intValue()).setVisibility(8);
            i += 1;
          }
        }
        if (((List)localObject1).size() == 6)
        {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365582).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365583).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365584).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365574).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365575).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365576).setVisibility(8);
          parambcgy = new StringBuilder("");
          i = 0;
          label630:
          if (i >= ((List)localObject1).size()) {
            break label751;
          }
          if (i != ((List)localObject1).size() - 1) {
            break label723;
          }
          parambcgy.append(((bcdx)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          i += 1;
          break label630;
          if (((List)localObject1).size() != 10) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365581).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365576).setVisibility(8);
          break;
          label723:
          parambcgy.append(((bcdx)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString).append("::");
        }
        label751:
        localObject2 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(3));
        if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue()))
        {
          bcni.a("home_page", "exp_entry", new String[] { parambcgy.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
          bcjy.a(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(bcjy.a(this.jdField_a_of_type_Int)).ver4(parambcgy.toString()).ver7("{experiment_id:" + bcjy.jdField_b_of_type_JavaLangString + "}"));
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          new aokg((QQAppInterface)localObject2).b((QQAppInterface)localObject2, "exp_entry", "all_result", bcjy.a(this.jdField_a_of_type_Int), "", parambcgy.toString(), "{experiment_id:" + bcjy.jdField_b_of_type_JavaLangString + "}");
          SearchEntryFragment.mIsModelsReported.put(Integer.valueOf(3), Boolean.valueOf(true));
          i = SearchEntryFragment.a(this.jdField_a_of_type_Int);
          parambcgy = ((List)localObject1).iterator();
          while (parambcgy.hasNext())
          {
            localObject1 = (bcdx)parambcgy.next();
            if (localObject1 != null) {
              bcjy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, i, "0X8009D1B", 0, 0, ((bcdx)localObject1).jdField_a_of_type_JavaLangString, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxx
 * JD-Core Version:    0.7.0.1
 */