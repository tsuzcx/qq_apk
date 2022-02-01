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

public class bbfe
  extends bbfd<View>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean b;
  
  public bbfe(int paramInt, boolean paramBoolean)
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
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131563037, null);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370094));
      return this.jdField_a_of_type_AndroidViewView;
    }
  }
  
  public List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365531));
    localArrayList.add(Integer.valueOf(2131365535));
    localArrayList.add(Integer.valueOf(2131365536));
    localArrayList.add(Integer.valueOf(2131365537));
    localArrayList.add(Integer.valueOf(2131365538));
    localArrayList.add(Integer.valueOf(2131365539));
    localArrayList.add(Integer.valueOf(2131365540));
    localArrayList.add(Integer.valueOf(2131365541));
    localArrayList.add(Integer.valueOf(2131365542));
    localArrayList.add(Integer.valueOf(2131365532));
    localArrayList.add(Integer.valueOf(2131365533));
    localArrayList.add(Integer.valueOf(2131365534));
    return localArrayList;
  }
  
  public void a()
  {
    ThreadManager.post(new BusinessSearchEntryModel.2(this, new bbld(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3, this.jdField_a_of_type_Int, this.b)), 5, null, true);
  }
  
  public void a(bbof parambbof)
  {
    b(parambbof);
  }
  
  public List<Integer> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(2131365531));
    localArrayList.add(Integer.valueOf(2131365535));
    localArrayList.add(Integer.valueOf(2131365536));
    localArrayList.add(Integer.valueOf(2131365537));
    localArrayList.add(Integer.valueOf(2131365538));
    localArrayList.add(Integer.valueOf(2131365540));
    localArrayList.add(Integer.valueOf(2131365541));
    localArrayList.add(Integer.valueOf(2131365542));
    localArrayList.add(Integer.valueOf(2131365532));
    localArrayList.add(Integer.valueOf(2131365533));
    return localArrayList;
  }
  
  public void b(bbof parambbof)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    parambbof = (bbld)parambbof;
    if (parambbof == null) {}
    for (;;)
    {
      return;
      Object localObject1 = parambbof.a;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        label78:
        int i;
        label80:
        bble localbble;
        View localView1;
        View localView2;
        Object localObject3;
        if (((List)localObject1).size() <= 6)
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (((List)localObject1).size() != 10) {
            break label424;
          }
          parambbof = b();
          i = 0;
          if (i >= ((List)localObject1).size()) {
            break label463;
          }
          localbble = (bble)((List)localObject1).get(i);
          localView1 = this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)parambbof.get(i)).intValue());
          localView2 = localView1.findViewById(2131376278);
          TextView localTextView = (TextView)localView1.findViewById(2131365530);
          URLImageView localURLImageView = (URLImageView)localView1.findViewById(2131365529);
          localView1.setVisibility(0);
          localObject3 = new ColorDrawable();
          if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            break label432;
          }
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167254));
          label209:
          if (!TextUtils.isEmpty(localbble.jdField_b_of_type_JavaLangString))
          {
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mRequestHeight = afur.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mRequestWidth = afur.a(28.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
            localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
            localObject3 = URLDrawable.getDrawable(localbble.jdField_b_of_type_JavaLangString, localURLDrawableOptions);
            if (localURLImageView != null) {
              localURLImageView.setImageDrawable((Drawable)localObject3);
            }
          }
          localTextView.setText(localbble.jdField_a_of_type_JavaLangString);
          int j = bgsg.a(localbble.c, (String)localObject2);
          boolean bool = bgsg.a(localbble.c, (String)localObject2);
          if ((localbble.jdField_a_of_type_Int != 1) || ((localbble.jdField_b_of_type_Int <= j) && ((localbble.jdField_b_of_type_Int != j) || (bool)))) {
            break label453;
          }
          localView2.setVisibility(0);
        }
        for (;;)
        {
          bgsg.a(localbble.c, localbble.jdField_b_of_type_Int, (String)localObject2);
          localView1.setOnClickListener(new bbff(this, localView1, localbble, localView2, (String)localObject2, (List)localObject1));
          i += 1;
          break label80;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          break;
          label424:
          parambbof = a();
          break label78;
          label432:
          ((ColorDrawable)localObject3).setColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167253));
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
            this.jdField_a_of_type_AndroidViewView.findViewById(((Integer)parambbof.get(i)).intValue()).setVisibility(8);
            i += 1;
          }
        }
        if (((List)localObject1).size() == 6)
        {
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365540).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365541).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365542).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365532).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365533).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365534).setVisibility(8);
          parambbof = new StringBuilder("");
          i = 0;
          label630:
          if (i >= ((List)localObject1).size()) {
            break label751;
          }
          if (i != ((List)localObject1).size() - 1) {
            break label723;
          }
          parambbof.append(((bble)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString);
        }
        for (;;)
        {
          i += 1;
          break label630;
          if (((List)localObject1).size() != 10) {
            break;
          }
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365539).setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.findViewById(2131365534).setVisibility(8);
          break;
          label723:
          parambbof.append(((bble)((List)localObject1).get(i)).jdField_a_of_type_JavaLangString).append("::");
        }
        label751:
        localObject2 = (Boolean)SearchEntryFragment.a.get(Integer.valueOf(3));
        if ((localObject2 == null) || (!((Boolean)localObject2).booleanValue()))
        {
          bbup.a("home_page", "exp_entry", new String[] { parambbof.toString(), "", String.valueOf(this.jdField_a_of_type_Int) });
          bbrf.a(null, new ReportModelDC02528().module("all_result").action("exp_entry").ver2(bbrf.a(this.jdField_a_of_type_Int)).ver4(parambbof.toString()).ver7("{experiment_id:" + bbrf.jdField_b_of_type_JavaLangString + "}"));
          localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          new anxu((QQAppInterface)localObject2).b((QQAppInterface)localObject2, "exp_entry", "all_result", bbrf.a(this.jdField_a_of_type_Int), "", parambbof.toString(), "{experiment_id:" + bbrf.jdField_b_of_type_JavaLangString + "}");
          SearchEntryFragment.a.put(Integer.valueOf(3), Boolean.valueOf(true));
          i = SearchEntryFragment.a(this.jdField_a_of_type_Int);
          parambbof = ((List)localObject1).iterator();
          while (parambbof.hasNext())
          {
            localObject1 = (bble)parambbof.next();
            if (localObject1 != null) {
              bbrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, i, "0X8009D1B", 0, 0, ((bble)localObject1).jdField_a_of_type_JavaLangString, null);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfe
 * JD-Core Version:    0.7.0.1
 */