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

public class bars
  extends barr<View>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean b;
  
  public bars(int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131562953, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370174));
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365606));
    localArrayList.add(Integer.valueOf(2131365610));
    localArrayList.add(Integer.valueOf(2131365611));
    localArrayList.add(Integer.valueOf(2131365612));
    localArrayList.add(Integer.valueOf(2131365613));
    localArrayList.add(Integer.valueOf(2131365614));
    localArrayList.add(Integer.valueOf(2131365615));
    localArrayList.add(Integer.valueOf(2131365616));
    localArrayList.add(Integer.valueOf(2131365617));
    localArrayList.add(Integer.valueOf(2131365607));
    localArrayList.add(Integer.valueOf(2131365608));
    localArrayList.add(Integer.valueOf(2131365609));
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new bawy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, this.jdField_a_of_type_Int, this.b)), 5, null, true);
  }
  
  public void a(bbaa parambbaa)
  {
    b(parambbaa);
  }
  
  public List<Integer> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365606));
    localArrayList.add(Integer.valueOf(2131365610));
    localArrayList.add(Integer.valueOf(2131365611));
    localArrayList.add(Integer.valueOf(2131365612));
    localArrayList.add(Integer.valueOf(2131365613));
    localArrayList.add(Integer.valueOf(2131365615));
    localArrayList.add(Integer.valueOf(2131365616));
    localArrayList.add(Integer.valueOf(2131365617));
    localArrayList.add(Integer.valueOf(2131365607));
    localArrayList.add(Integer.valueOf(2131365608));
    return localArrayList;
  }
  
  public void b(bbaa parambbaa)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    parambbaa = (bawy)parambbaa;
    if (parambbaa == null) {}
    for (;;)
    {
      return;
      Object localObject1 = parambbaa.a;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        label78:
        int i;
        label80:
        bawz localbawz;
        View localView1;
        View localView2;
        Object localObject3;
        if (((List)localObject1).size() <= 6)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (((List)localObject1).size() != 10) {
            break label424;
          }
          parambbaa = b();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label463;
          }
          localbawz = (bawz)((List)localObject1).get(i);
          localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)parambbaa.get(i)).intValue());
          localView2 = localView1.findViewById(2131376186);
          TextView localTextView = (TextView)localView1.findViewById(2131365605);
          URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131365604);
          localView1.setVisibility(0);
          localObject3 = new ColorDrawable();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label432;
          }
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167308));
          label209:
          if (!TextUtils.isEmpty(localbawz.jdField_b_of_type_JavaLangString))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mRequestWidth = AIOUtils.dp2px(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
            localObject3 = URLDrawable.getDrawable(localbawz.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
            if (localURLImageView != null) {
              localURLImageView.setImageDrawable((Drawable)localObject3);
            }
          }
          localTextView.setText(localbawz.jdField_a_of_type_JavaLangString);
          int j = bfyz.a(localbawz.c, (String)localObject2);
          boolean bool = bfyz.a(localbawz.c, (String)localObject2);
          if ((localbawz.jdField_a_of_type_Int != 1) || ((localbawz.jdField_b_of_type_Int <= j) && ((localbawz.jdField_b_of_type_Int != j) || (bool)))) {
            break label453;
          }
          localView2.setVisibility(0);
        }
        for (;;)
        {
          bfyz.a(localbawz.c, localbawz.jdField_b_of_type_Int, (String)localObject2);
          localView1.setOnClickListener(new bart(this, localView1, localbawz, localView2, (String)localObject2, (List)localObject1));
          i += 1;
          break label80;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          break;
          label424:
          parambbaa = a();
          break label78;
          label432:
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167307));
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
            this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)parambbaa.get(i)).intValue()).setVisibility(8);
            i += 1;
          }
        }
        if (((List)localObject1).size() == 6)
        {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365615).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365616).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365617).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365607).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365608).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365609).setVisibility(8);
          parambbaa = new StringBuilder("");
          i = 0;
          label630:
          if (i >= ((List)localObject1).size()) {
            break label751;
          }
          if (i != ((List)localObject1).size() - 1) {
            break label723;
          }
          parambbaa.append(((bawz)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          i += 1;
          break label630;
          if (((List)localObject1).size() != 10) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365614).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365609).setVisibility(8);
          break;
          label723:
          parambbaa.append(((bawz)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString).append("::");
        }
        label751:
        localObject2 = (Boolean)SearchEntryFragment.mIsModelsReported.get(Integer.valueOf(3));
        if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue()))
        {
          bbgk.a("home_page", "exp_entry", new String[] { parambbaa.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
          bbda.a(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(bbda.a(this.jdField_a_of_type_Int)).ver4(parambbaa.toString()).ver7("{experiment_id:" + bbda.jdField_b_of_type_JavaLangString + "}"));
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          new andr((QQAppInterface)localObject2).b((QQAppInterface)localObject2, "exp_entry", "all_result", bbda.a(this.jdField_a_of_type_Int), "", parambbaa.toString(), "{experiment_id:" + bbda.jdField_b_of_type_JavaLangString + "}");
          SearchEntryFragment.mIsModelsReported.put(Integer.valueOf(3), Boolean.valueOf(true));
          i = SearchEntryFragment.a(this.jdField_a_of_type_Int);
          parambbaa = ((List)localObject1).iterator();
          while (parambbaa.hasNext())
          {
            localObject1 = (bawz)parambbaa.next();
            if (localObject1 != null) {
              bbda.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, i, "0X8009D1B", 0, 0, ((bawz)localObject1).jdField_a_of_type_JavaLangString, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bars
 * JD-Core Version:    0.7.0.1
 */