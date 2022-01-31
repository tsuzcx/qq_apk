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

public class awhh
  extends awhg<View>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public awhh(int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131562580, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369407));
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839124);
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365205));
    localArrayList.add(Integer.valueOf(2131365209));
    localArrayList.add(Integer.valueOf(2131365210));
    localArrayList.add(Integer.valueOf(2131365211));
    localArrayList.add(Integer.valueOf(2131365212));
    localArrayList.add(Integer.valueOf(2131365213));
    localArrayList.add(Integer.valueOf(2131365214));
    localArrayList.add(Integer.valueOf(2131365215));
    localArrayList.add(Integer.valueOf(2131365216));
    localArrayList.add(Integer.valueOf(2131365206));
    localArrayList.add(Integer.valueOf(2131365207));
    localArrayList.add(Integer.valueOf(2131365208));
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new awml(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean)), 5, null, true);
  }
  
  public void a(awpn paramawpn)
  {
    b(paramawpn);
  }
  
  public List<Integer> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365205));
    localArrayList.add(Integer.valueOf(2131365209));
    localArrayList.add(Integer.valueOf(2131365210));
    localArrayList.add(Integer.valueOf(2131365211));
    localArrayList.add(Integer.valueOf(2131365212));
    localArrayList.add(Integer.valueOf(2131365214));
    localArrayList.add(Integer.valueOf(2131365215));
    localArrayList.add(Integer.valueOf(2131365216));
    localArrayList.add(Integer.valueOf(2131365206));
    localArrayList.add(Integer.valueOf(2131365207));
    return localArrayList;
  }
  
  public void b(awpn paramawpn)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    paramawpn = (awml)paramawpn;
    if (paramawpn == null) {}
    for (;;)
    {
      return;
      List localList = paramawpn.a;
      if ((localList != null) && (localList.size() != 0))
      {
        label78:
        int i;
        label80:
        awmm localawmm;
        View localView1;
        View localView2;
        Object localObject2;
        if (localList.size() <= 6)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (localList.size() != 10) {
            break label424;
          }
          paramawpn = b();
          i = 0;
          if (i >= localList.size()) {
            break label463;
          }
          localawmm = (awmm)localList.get(i);
          localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)paramawpn.get(i)).intValue());
          localView2 = localView1.findViewById(2131375028);
          TextView localTextView = (TextView)localView1.findViewById(2131365204);
          URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131365203);
          localView1.setVisibility(0);
          localObject2 = new ColorDrawable();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label432;
          }
          ((ColorDrawable)localObject2).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167111));
          label209:
          if (!TextUtils.isEmpty(localawmm.jdField_b_of_type_JavaLangString))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = actn.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mRequestWidth = actn.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
            localObject2 = URLDrawable.getDrawable(localawmm.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
            if (localURLImageView != null) {
              localURLImageView.setImageDrawable((Drawable)localObject2);
            }
          }
          localTextView.setText(localawmm.jdField_a_of_type_JavaLangString);
          int j = bbjn.a(localawmm.c, (String)localObject1);
          boolean bool = bbjn.a(localawmm.c, (String)localObject1);
          if ((localawmm.jdField_a_of_type_Int != 1) || ((localawmm.jdField_b_of_type_Int <= j) && ((localawmm.jdField_b_of_type_Int != j) || (bool)))) {
            break label453;
          }
          localView2.setVisibility(0);
        }
        for (;;)
        {
          bbjn.a(localawmm.c, localawmm.jdField_b_of_type_Int, (String)localObject1);
          localView1.setOnClickListener(new awhi(this, localView1, localawmm, localView2, (String)localObject1, localList));
          i += 1;
          break label80;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          break;
          label424:
          paramawpn = a();
          break label78;
          label432:
          ((ColorDrawable)localObject2).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167110));
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
            this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)paramawpn.get(i)).intValue()).setVisibility(8);
            i += 1;
          }
        }
        if (localList.size() == 6)
        {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365214).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365215).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365216).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365206).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365207).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365208).setVisibility(8);
          paramawpn = new StringBuilder("");
          i = 0;
          label630:
          if (i >= localList.size()) {
            break label751;
          }
          if (i != localList.size() - 1) {
            break label723;
          }
          paramawpn.append(((awmm)localList.get(i)).jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          i += 1;
          break label630;
          if (localList.size() != 10) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365213).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365208).setVisibility(8);
          break;
          label723:
          paramawpn.append(((awmm)localList.get(i)).jdField_a_of_type_JavaLangString).append("::");
        }
        label751:
        localObject1 = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(3));
        if ((localObject1 == null) || (!((Boolean)localObject1).booleanValue()))
        {
          awvy.a("home_page", "exp_entry", new String[] { paramawpn.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
          awso.a(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(awso.a(this.jdField_a_of_type_Int)).ver4(paramawpn.toString()).ver7("{experiment_id:" + awso.jdField_b_of_type_JavaLangString + "}"));
          SearchEntryFragment.a.put(Integer.valueOf(3), Boolean.valueOf(true));
          i = SearchEntryFragment.a(this.jdField_a_of_type_Int);
          paramawpn = localList.iterator();
          while (paramawpn.hasNext())
          {
            localObject1 = (awmm)paramawpn.next();
            if (localObject1 != null) {
              awso.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, i, "0X8009D1B", 0, 0, ((awmm)localObject1).jdField_a_of_type_JavaLangString, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awhh
 * JD-Core Version:    0.7.0.1
 */