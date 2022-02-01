import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unite.search.DynamicTabSearch.SubHotWord;

public class bauu
  extends andq
{
  public bauu(ActiveEntitySearchFragment paramActiveEntitySearchFragment) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (!this.a.isAdded()) {
      QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, "Unify handleTabSearchError, fragment is detached ..., reqKeyword=" + paramString1 + " isFirstReq=" + paramBoolean + " reqTime=" + paramString2 + " resultCode=" + paramInt + " errorMsg=" + paramString3);
    }
    while ((!TextUtils.equals(paramString2, this.a.jdField_d_of_type_JavaLangString)) || (!ActiveEntitySearchFragment.a(this.a.jdField_a_of_type_ArrayOfLong, paramArrayOfLong)) || (!this.a.jdField_b_of_type_JavaLangString.equals(paramString1))) {
      return;
    }
    this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.a.jdField_e_of_type_Boolean = false;
    this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.a.g.setVisibility(0);
      if (this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    }
    for (;;)
    {
      try
      {
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.a.getResources(), 2130842348);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.jdField_a_of_type_AndroidGraphicsBitmap);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131698924));
        this.a.g.setOnClickListener(new bauw(this));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchError code=" + paramInt + " mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString);
        return;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, paramString2, new Object[0]);
        continue;
      }
      this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new baux(this));
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<bays> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4, int paramInt)
  {
    if (!this.a.isAdded())
    {
      QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, "Unify handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " reqTime=" + paramString2 + " lastReqTime=" + this.a.jdField_d_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (!TextUtils.equals(paramString2, this.a.jdField_d_of_type_JavaLangString))
    {
      QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " reqTime=" + paramString2 + " lastReqTime=" + this.a.jdField_d_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if ((!ActiveEntitySearchFragment.a(this.a.jdField_a_of_type_ArrayOfLong, paramArrayOfLong)) || (!paramString1.equals(this.a.jdField_b_of_type_JavaLangString)))
    {
      QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchResult. masks=" + this.a.jdField_a_of_type_ArrayOfLong + " reqMasks=" + paramArrayOfLong + " reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchResult result=" + paramList);
      }
      a(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    if (paramInt == 2)
    {
      this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.a.jdField_e_of_type_Boolean = false;
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.a.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.a.c.setVisibility(8);
      this.a.g.setVisibility(0);
      try
      {
        if (this.a.isAdded()) {
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeResource(this.a.getResources(), 2130842337));
        }
        if (2 == paramInt)
        {
          paramString1 = this.a.getString(2131717984);
          this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
          return;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        for (;;)
        {
          QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, paramString1, new Object[0]);
          continue;
          paramString1 = amtj.a(2131698921);
        }
      }
    }
    paramString2 = new HashSet();
    Object localObject1 = paramList.iterator();
    long l1 = -1L;
    long l2 = -1L;
    int i = 0;
    label533:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label680:
    label742:
    long l3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bays)((Iterator)localObject1).next();
      if (((bays)localObject2).a() == null) {
        break label3586;
      }
      if (!(localObject2 instanceof baxq)) {
        break label3583;
      }
      localObject3 = (baxq)localObject2;
      localObject4 = ((baxq)localObject3).a();
      Iterator localIterator = ((List)localObject4).iterator();
      while (localIterator.hasNext())
      {
        Object localObject5 = (bayt)localIterator.next();
        if ((localObject5 instanceof baxr))
        {
          localObject5 = (baxr)localObject5;
          if (ActiveEntitySearchActivity.b) {
            ((baxr)localObject5).o = 1;
          }
          paramString2.add(Long.valueOf(((baxr)localObject5).d()));
        }
      }
      if (l1 != -1L) {
        break label3580;
      }
      l1 = ((baxq)localObject3).a;
      l2 = ((baxq)localObject3).a;
      if ((((List)localObject4).size() > 0) && (((baxq)localObject3).a == 1001L))
      {
        bcef.b(null, "dc00898", "", "", "0X800A339", "0X800A339", 1, 0, "", "", "", "");
        paramInt = i + ((bays)localObject2).a().size();
        l3 = l1;
        l1 = l2;
        l2 = l3;
      }
    }
    for (;;)
    {
      l3 = l1;
      l1 = l2;
      l2 = l3;
      i = paramInt;
      break label533;
      if ((((List)localObject4).size() > 0) && (((baxq)localObject3).a == 1002L)) {
        bcef.b(null, "dc00898", "", "", "0X800A339", "0X800A339", 2, 0, "", "", "", "");
      }
      break label742;
      this.a.jdField_b_of_type_JavaUtilList.addAll(paramString2);
      ActiveEntitySearchFragment.a(this.a, paramString3);
      ActiveEntitySearchFragment.a(this.a, paramList1);
      if (!paramBoolean1)
      {
        paramString3 = new ArrayList();
        paramString3.addAll(paramString2);
        bbgk.a("sub_result", "load_result", new String[] { this.a.jdField_b_of_type_JavaLangString, bbgk.a(paramString3), "", bbgk.a("dynamic_tab_search.1", this.a.jdField_a_of_type_ArrayOfLong) });
      }
      paramString2 = this.a.jdField_a_of_type_JavaUtilList;
      boolean bool1;
      label1060:
      boolean bool2;
      if (!paramBoolean1)
      {
        bool1 = true;
        bbgf.a(paramString2, paramList, bool1, this.a.jdField_a_of_type_ArrayOfLong, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
        if (i != 0) {
          break label1515;
        }
        if ((this.a.getActivity() instanceof basu)) {}
        switch (((basu)this.a.getActivity()).a())
        {
        case 2: 
        default: 
          if (QLog.isColorLevel()) {
            QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.a.jdField_b_of_type_Int + "   newSearchIndex:" + this.a.jdField_a_of_type_Int + " result.size():" + i);
          }
          this.a.jdField_e_of_type_AndroidViewView.setVisibility(8);
          this.a.jdField_f_of_type_AndroidViewView.setVisibility(8);
          this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
          this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.a.jdField_e_of_type_Boolean = false;
          this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
          this.a.jdField_d_of_type_Boolean = paramBoolean2;
          bool2 = false;
          paramArrayOfByte = "";
          if (!TextUtils.isEmpty(paramString4))
          {
            paramString2 = paramArrayOfByte;
            bool1 = bool2;
          }
          break;
        }
      }
      int j;
      for (;;)
      {
        try
        {
          paramString3 = new JSONObject(paramString4);
          paramString2 = paramArrayOfByte;
          bool1 = bool2;
          bool2 = paramString3.optBoolean("buttonShow");
          paramString2 = paramArrayOfByte;
          bool1 = bool2;
          paramArrayOfByte = paramString3.optString("buttonText");
          paramString2 = paramArrayOfByte;
          bool1 = bool2;
          paramString3 = paramString3.optString("buttonJmpUrl");
          bool1 = bool2;
          paramString2 = paramString3;
        }
        catch (JSONException paramArrayOfByte)
        {
          label1515:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchResult extension parse error! " + QLog.getStackTraceString(paramArrayOfByte));
          paramString3 = "";
          paramArrayOfByte = paramString2;
          paramString2 = paramString3;
          continue;
        }
        if (!paramBoolean2) {
          break label1830;
        }
        this.a.c.setVisibility(0);
        if ((this.a.jdField_a_of_type_ArrayOfLong == null) || (this.a.jdField_a_of_type_ArrayOfLong.length != 2)) {
          break label1830;
        }
        paramString3 = new ArrayList();
        paramList1 = this.a.jdField_a_of_type_ArrayOfLong;
        j = paramList1.length;
        paramInt = 0;
        if (paramInt >= j) {
          break label1786;
        }
        paramString3.add(Long.valueOf(paramList1[paramInt]));
        paramInt += 1;
        continue;
        bool1 = false;
        break;
        bbgk.a("sub_result", "no_result", new String[] { this.a.jdField_b_of_type_JavaLangString, bbgk.a(this.a.jdField_a_of_type_ArrayOfLong), "", bbgk.a("dynamic_tab_search.1", paramArrayOfLong) });
        break label1060;
        bbgk.a("all_result", "exp_tab_empty", new String[] { this.a.jdField_b_of_type_JavaLangString, bbgk.a(this.a.jdField_a_of_type_ArrayOfLong), "", bbgk.a("dynamic_tab_search.1", paramArrayOfLong) });
        break label1060;
        if ((this.a.jdField_a_of_type_ArrayOfByte != null) || (!(this.a.getActivity() instanceof basu))) {
          break label1060;
        }
        paramString2 = (basu)this.a.getActivity();
        switch (paramString2.a())
        {
        case 2: 
        default: 
          break;
        case 1: 
          bbgk.a("all_result", "exp_tab_page", new String[] { this.a.jdField_b_of_type_JavaLangString, bbgk.a(this.a.jdField_b_of_type_JavaUtilList), "", bbgk.a("UnifySearch.Unite", paramString2.a()) });
          break;
        case 3: 
          bbgk.a("sub_result", "exp_result", new String[] { paramString2.a(), bbgk.a(this.a.jdField_b_of_type_JavaUtilList), "", bbgk.a("dynamic_tab_search.1", paramString2.a()) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchResult extension is null");
          }
          bool1 = false;
          paramString2 = "";
          paramArrayOfByte = "";
        }
      }
      label1786:
      if ((paramString3.contains(Long.valueOf(1001L))) && (paramString3.contains(Long.valueOf(1002L)))) {
        this.a.c.setVisibility(8);
      }
      label1830:
      int k;
      if ((!TextUtils.isEmpty(ActiveEntitySearchFragment.a(this.a))) && (ActiveEntitySearchFragment.a(this.a).size() > 0))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(ActiveEntitySearchFragment.a(this.a));
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
        paramString3 = this.a.getActivity();
        if ((paramString3 == null) || (paramString3.isFinishing()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify activity is finished. in handleTabSearchResult.");
          return;
        }
        j = DisplayUtil.dip2px(paramString3, 8.0F);
        k = DisplayUtil.dip2px(paramString3, 10.0F);
        int m = DisplayUtil.dip2px(paramString3, 2.0F);
        paramList1 = new GradientDrawable();
        paramList1.setCornerRadius(DisplayUtil.dip2px(this.a.getActivity(), 15.0F));
        paramInt = Color.parseColor("#E2E2E2");
        bool2 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        if (bool2) {
          paramInt = Color.parseColor("#5a86bb");
        }
        paramList1.setStroke(1, paramInt);
        paramString4 = ActiveEntitySearchFragment.a(this.a).iterator();
        while (paramString4.hasNext())
        {
          localObject1 = (DynamicTabSearch.SubHotWord)paramString4.next();
          localObject2 = ((DynamicTabSearch.SubHotWord)localObject1).show_word.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = new TextView(paramString3);
            localObject4 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject4).rightMargin = j;
            ((TextView)localObject3).setPadding(k, m, k, m);
            paramInt = Color.parseColor("#000000");
            if (bool2) {
              paramInt = Color.parseColor("#5a86bb");
            }
            ((TextView)localObject3).setTextColor(paramInt);
            if (Build.VERSION.SDK_INT < 16) {
              ((TextView)localObject3).setBackgroundDrawable(paramList1.mutate());
            }
            for (;;)
            {
              ((TextView)localObject3).setText((CharSequence)localObject2);
              ((TextView)localObject3).setGravity(17);
              ((TextView)localObject3).setTextSize(1, 14.0F);
              ((TextView)localObject3).setContentDescription((CharSequence)localObject2);
              ((TextView)localObject3).setOnClickListener(this.a);
              ((TextView)localObject3).setTag(2131368187, localObject1);
              this.a.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
              break;
              ((TextView)localObject3).setBackground(paramList1.mutate());
            }
          }
        }
        if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == 0)
        {
          this.a.jdField_d_of_type_AndroidViewView.setVisibility(8);
          if ((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty())) {
            break label2804;
          }
          paramString2 = batb.a(paramList, paramBoolean1, this.a.jdField_f_of_type_Boolean);
          if ((paramBoolean1) || (l1 != ActiveEntitySearchFragment.a(this.a)) || (paramBoolean3) || (paramString2 == null) || (paramString2.size() <= 0)) {
            break label2596;
          }
          paramArrayOfByte = (bayr)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_JavaUtilList.size() - 1);
          paramString2.remove(0);
          j = 0;
          paramInt = 0;
          label2390:
          if (paramInt >= paramString2.size()) {
            break label3573;
          }
          if (!((bayr)paramString2.get(paramInt) instanceof baya)) {
            break label2583;
          }
        }
      }
      for (;;)
      {
        if ((paramArrayOfByte instanceof bayt))
        {
          paramArrayOfByte = (bayt)paramArrayOfByte;
          j = paramArrayOfByte.a();
          bbgn.a(paramArrayOfByte, j + paramInt, j - 1);
        }
        for (;;)
        {
          k = 0;
          for (;;)
          {
            if (k < paramInt)
            {
              paramArrayOfByte = (bayr)paramString2.get(k);
              if ((paramArrayOfByte instanceof bayt)) {
                bbgn.a((bayt)paramArrayOfByte, j + paramInt, j + k);
              }
              k += 1;
              continue;
              if (((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty())) && ((paramList == null) || (paramList.isEmpty()))) {
                break;
              }
              this.a.jdField_d_of_type_AndroidViewView.setVisibility(0);
              break;
              this.a.jdField_d_of_type_AndroidViewView.setVisibility(8);
              break;
              label2583:
              j = paramInt;
              paramInt += 1;
              break label2390;
            }
          }
          label2596:
          this.a.a(paramString2);
          this.a.jdField_a_of_type_JavaUtilList.addAll(paramString2);
          this.a.jdField_a_of_type_Baut.a(this.a.jdField_a_of_type_JavaUtilList);
          ActiveEntitySearchFragment.a(this.a, l2);
          if (!this.a.jdField_d_of_type_Boolean)
          {
            paramString2 = this.a;
            paramString2.jdField_b_of_type_Int += i;
            paramString2 = this.a;
            paramString2.jdField_a_of_type_Int += 1;
            if (this.a.jdField_b_of_type_Int > 10)
            {
              this.a.jdField_a_of_type_Int = 0;
              this.a.jdField_b_of_type_Int = 0;
            }
          }
          else
          {
            label2714:
            if (!paramBoolean2) {
              break label3484;
            }
            if (QLog.isColorLevel()) {
              QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchResult isEnd = true mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString + "  fragmentMask=" + Arrays.toString(this.a.jdField_a_of_type_ArrayOfLong));
            }
          }
          for (;;)
          {
            ActiveEntitySearchActivity.a = true;
            return;
            label2804:
            if ((paramList == null) || (paramList.isEmpty()))
            {
              this.a.g.setVisibility(0);
              paramString3 = (amvo)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
              if ((!bool1) && (paramString3.jdField_d_of_type_Boolean)) {
                if (this.a.jdField_a_of_type_Aiid == null)
                {
                  this.a.jdField_a_of_type_Aiid = new aiih(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.getActivity(), this.a.jdField_b_of_type_ComTencentWidgetXListView, null);
                  paramString2 = this.a.jdField_a_of_type_Aiid.a();
                  paramArrayOfByte = new TextView(this.a.getActivity());
                  paramArrayOfByte.setGravity(17);
                  paramArrayOfByte.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(105.0F, this.a.getResources())));
                  paramArrayOfByte.setTextColor(this.a.getResources().getColor(2131167096));
                  paramArrayOfByte.setTextSize(1, 17.0F);
                  paramArrayOfByte.setText(amtj.a(2131698926));
                  paramArrayOfByte.setBackgroundResource(2130838892);
                  paramString2.addHeaderView(paramArrayOfByte);
                  paramArrayOfByte = new TextView(this.a.getActivity());
                  paramArrayOfByte.setTextColor(this.a.getResources().getColor(2131167096));
                  paramArrayOfByte.setTextSize(1, 14.0F);
                  paramArrayOfByte.setGravity(16);
                  paramArrayOfByte.setPadding(AIOUtils.dp2px(15.0F, this.a.getResources()), 0, 0, 0);
                  paramArrayOfByte.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(40.0F, this.a.getResources())));
                  paramArrayOfByte.setText(amtj.a(2131698932));
                  paramArrayOfByte.setBackgroundResource(2130838892);
                  paramString2.addHeaderView(paramArrayOfByte);
                  this.a.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(0);
                  this.a.c.setVisibility(8);
                }
              }
            }
            for (;;)
            {
              for (;;)
              {
                label3141:
                label3152:
                paramString2 = batb.a(paramList, paramBoolean1, this.a.jdField_f_of_type_Boolean);
                this.a.a(paramString2);
                this.a.jdField_a_of_type_JavaUtilList = paramString2;
                this.a.jdField_a_of_type_Baut.a(this.a.jdField_a_of_type_JavaUtilList);
                break;
                this.a.jdField_a_of_type_Aiid.e();
                break label3141;
                this.a.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
                if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
                try
                {
                  if (this.a.isAdded())
                  {
                    this.a.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.a.getResources(), 2130842348);
                    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.jdField_a_of_type_AndroidGraphicsBitmap);
                  }
                  this.a.jdField_b_of_type_AndroidWidgetTextView.setText(amtj.a(2131698921));
                  if (bool1)
                  {
                    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
                    this.a.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bauv(this, paramString2));
                    if (TextUtils.isEmpty(paramArrayOfByte)) {
                      break label3152;
                    }
                    this.a.jdField_a_of_type_AndroidWidgetButton.setText(paramArrayOfByte);
                    this.a.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, DisplayUtil.dip2px(this.a.jdField_b_of_type_AndroidWidgetTextView.getContext(), 15.0F), 0, 0);
                  }
                }
                catch (OutOfMemoryError paramString3)
                {
                  for (;;)
                  {
                    QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, paramString3, new Object[0]);
                  }
                  this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
                }
              }
              break label3152;
              this.a.g.setVisibility(8);
            }
            if (this.a.jdField_a_of_type_Int >= 3)
            {
              this.a.jdField_d_of_type_Boolean = true;
              break label2714;
            }
            this.a.b(this.a.jdField_b_of_type_JavaLangString);
            break label2714;
            label3484:
            if (QLog.isColorLevel()) {
              QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "Unify handleTabSearchResult isEnd = false mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString + "  fragmentMask=" + Arrays.toString(this.a.jdField_a_of_type_ArrayOfLong));
            }
          }
          j = 0;
        }
        label3573:
        paramInt = j;
      }
      label3580:
      break label680;
      label3583:
      break label742;
      label3586:
      l3 = l2;
      paramInt = i;
      l2 = l1;
      l1 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bauu
 * JD-Core Version:    0.7.0.1
 */