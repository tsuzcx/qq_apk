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

public class avho
  extends avhn<View>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public avho(int paramInt, boolean paramBoolean)
  {
    super(paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public View a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramBundle = paramQQAppInterface;
    if (paramQQAppInterface == null) {
      if (!(paramContext instanceof BaseActivity)) {
        break label120;
      }
    }
    label120:
    for (paramViewGroup = ((BaseActivity)paramContext).getAppRuntime();; paramViewGroup = null)
    {
      paramBundle = paramQQAppInterface;
      if ((paramViewGroup instanceof QQAppInterface)) {
        paramBundle = (QQAppInterface)paramViewGroup;
      }
      if (paramBundle == null) {
        return new View(paramContext);
      }
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131496980, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303737));
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839096);
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131299637));
    localArrayList.add(Integer.valueOf(2131299641));
    localArrayList.add(Integer.valueOf(2131299642));
    localArrayList.add(Integer.valueOf(2131299643));
    localArrayList.add(Integer.valueOf(2131299644));
    localArrayList.add(Integer.valueOf(2131299645));
    localArrayList.add(Integer.valueOf(2131299646));
    localArrayList.add(Integer.valueOf(2131299647));
    localArrayList.add(Integer.valueOf(2131299648));
    localArrayList.add(Integer.valueOf(2131299638));
    localArrayList.add(Integer.valueOf(2131299639));
    localArrayList.add(Integer.valueOf(2131299640));
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new avms(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean)), 5, null, true);
  }
  
  public void a(avpu paramavpu)
  {
    b(paramavpu);
  }
  
  public List<Integer> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131299637));
    localArrayList.add(Integer.valueOf(2131299641));
    localArrayList.add(Integer.valueOf(2131299642));
    localArrayList.add(Integer.valueOf(2131299643));
    localArrayList.add(Integer.valueOf(2131299644));
    localArrayList.add(Integer.valueOf(2131299646));
    localArrayList.add(Integer.valueOf(2131299647));
    localArrayList.add(Integer.valueOf(2131299648));
    localArrayList.add(Integer.valueOf(2131299638));
    localArrayList.add(Integer.valueOf(2131299639));
    return localArrayList;
  }
  
  public void b(avpu paramavpu)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    paramavpu = (avms)paramavpu;
    if (paramavpu == null) {}
    for (;;)
    {
      return;
      List localList = paramavpu.a;
      if ((localList != null) && (localList.size() != 0))
      {
        label78:
        int i;
        label80:
        avmt localavmt;
        View localView1;
        View localView2;
        Object localObject2;
        if (localList.size() <= 6)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (localList.size() != 10) {
            break label424;
          }
          paramavpu = b();
          i = 0;
          if (i >= localList.size()) {
            break label463;
          }
          localavmt = (avmt)localList.get(i);
          localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)paramavpu.get(i)).intValue());
          localView2 = localView1.findViewById(2131309284);
          TextView localTextView = (TextView)localView1.findViewById(2131299636);
          URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131299635);
          localView1.setVisibility(0);
          localObject2 = new ColorDrawable();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label432;
          }
          ((ColorDrawable)localObject2).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101514));
          label209:
          if (!TextUtils.isEmpty(localavmt.jdField_b_of_type_JavaLangString))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = aciy.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mRequestWidth = aciy.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
            localObject2 = URLDrawable.getDrawable(localavmt.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
            if (localURLImageView != null) {
              localURLImageView.setImageDrawable((Drawable)localObject2);
            }
          }
          localTextView.setText(localavmt.jdField_a_of_type_JavaLangString);
          int j = baig.a(localavmt.c, (String)localObject1);
          boolean bool = baig.a(localavmt.c, (String)localObject1);
          if ((localavmt.jdField_a_of_type_Int != 1) || ((localavmt.jdField_b_of_type_Int <= j) && ((localavmt.jdField_b_of_type_Int != j) || (bool)))) {
            break label453;
          }
          localView2.setVisibility(0);
        }
        for (;;)
        {
          baig.a(localavmt.c, localavmt.jdField_b_of_type_Int, (String)localObject1);
          localView1.setOnClickListener(new avhp(this, localView1, localavmt, localView2, (String)localObject1, localList));
          i += 1;
          break label80;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          break;
          label424:
          paramavpu = a();
          break label78;
          label432:
          ((ColorDrawable)localObject2).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101513));
          break label209;
          label453:
          localView2.setVisibility(8);
        }
        label463:
        if (localList.size() < 6)
        {
          i = localList.size();
          while (i < 6)
          {
            this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)paramavpu.get(i)).intValue()).setVisibility(8);
            i += 1;
          }
        }
        if (localList.size() == 6)
        {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131299646).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131299647).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131299648).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131299638).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131299639).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131299640).setVisibility(8);
          paramavpu = new StringBuilder("");
          i = 0;
          label630:
          if (i >= localList.size()) {
            break label751;
          }
          if (i != localList.size() - 1) {
            break label723;
          }
          paramavpu.append(((avmt)localList.get(i)).jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          i += 1;
          break label630;
          if (localList.size() != 10) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView.findViewById(2131299645).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131299640).setVisibility(8);
          break;
          label723:
          paramavpu.append(((avmt)localList.get(i)).jdField_a_of_type_JavaLangString).append("::");
        }
        label751:
        localObject1 = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(3));
        if ((localObject1 == null) || (!((Boolean)localObject1).booleanValue()))
        {
          avwf.a("home_page", "exp_entry", new String[] { paramavpu.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
          avsv.a(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(avsv.a(this.jdField_a_of_type_Int)).ver4(paramavpu.toString()).ver7("{experiment_id:" + avsv.jdField_b_of_type_JavaLangString + "}"));
          SearchEntryFragment.a.put(Integer.valueOf(3), Boolean.valueOf(true));
          i = SearchEntryFragment.a(this.jdField_a_of_type_Int);
          paramavpu = localList.iterator();
          while (paramavpu.hasNext())
          {
            localObject1 = (avmt)paramavpu.next();
            if (localObject1 != null) {
              avsv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, i, "0X8009D1B", 0, 0, ((avmt)localObject1).jdField_a_of_type_JavaLangString, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avho
 * JD-Core Version:    0.7.0.1
 */