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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
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

public class awkq
  extends akjb
{
  public awkq(ActiveEntitySearchFragment paramActiveEntitySearchFragment) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2, int paramInt, String paramString3, long[] paramArrayOfLong)
  {
    if (!this.a.isAdded()) {
      QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, "handleTabSearchError, fragment is detached ..., reqKeyword=" + paramString1 + " isFirstReq=" + paramBoolean + " reqTime=" + paramString2 + " resultCode=" + paramInt + " errorMsg=" + paramString3);
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
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.a.getResources(), 2130841820);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.jdField_a_of_type_AndroidGraphicsBitmap);
        this.a.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131699778));
        this.a.g.setOnClickListener(new awks(this));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchError code=" + paramInt + " mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString);
        return;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, paramString2, new Object[0]);
        continue;
      }
      this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new awkt(this));
    }
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean2, List<awoh> paramList, long[] paramArrayOfLong, String paramString3, List<DynamicTabSearch.SubHotWord> paramList1, boolean paramBoolean3, String paramString4)
  {
    if (!this.a.isAdded())
    {
      QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 1, "handleTabSearchResult, fragment is detached ..., reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " reqTime=" + paramString2 + " lastReqTime=" + this.a.jdField_d_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (!TextUtils.equals(paramString2, this.a.jdField_d_of_type_JavaLangString))
    {
      QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult. reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " reqTime=" + paramString2 + " lastReqTime=" + this.a.jdField_d_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if ((!ActiveEntitySearchFragment.a(this.a.jdField_a_of_type_ArrayOfLong, paramArrayOfLong)) || (!paramString1.equals(this.a.jdField_b_of_type_JavaLangString)))
    {
      QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult. masks=" + this.a.jdField_a_of_type_ArrayOfLong + " reqMasks=" + paramArrayOfLong + " reqKeyword=" + paramString1 + " keyword=" + this.a.jdField_b_of_type_JavaLangString + " isEnd1=" + paramBoolean2);
      return;
    }
    if (paramList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult result=" + paramList);
      }
      a(paramString1, paramBoolean1, paramString2, -1, "result = null", paramArrayOfLong);
      return;
    }
    paramString2 = new HashSet();
    Object localObject1 = paramList.iterator();
    long l1 = -1L;
    long l2 = -1L;
    int j = 0;
    label363:
    Object localObject2;
    Object localObject3;
    Object localObject4;
    label510:
    int i;
    label572:
    long l3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (awoh)((Iterator)localObject1).next();
      if (((awoh)localObject2).a() == null) {
        break label3403;
      }
      if (!(localObject2 instanceof awnf)) {
        break label3400;
      }
      localObject3 = (awnf)localObject2;
      localObject4 = ((awnf)localObject3).a();
      Iterator localIterator = ((List)localObject4).iterator();
      while (localIterator.hasNext())
      {
        Object localObject5 = (awoi)localIterator.next();
        if ((localObject5 instanceof awng))
        {
          localObject5 = (awng)localObject5;
          if (ActiveEntitySearchActivity.b) {
            ((awng)localObject5).l = 1;
          }
          paramString2.add(Long.valueOf(((awng)localObject5).d()));
        }
      }
      if (l1 != -1L) {
        break label3397;
      }
      l1 = ((awnf)localObject3).a;
      l2 = ((awnf)localObject3).a;
      if ((((List)localObject4).size() > 0) && (((awnf)localObject3).a == 1001L))
      {
        axqy.b(null, "dc00898", "", "", "0X800A339", "0X800A339", 1, 0, "", "", "", "");
        i = j + ((awoh)localObject2).a().size();
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
      j = i;
      break label363;
      if ((((List)localObject4).size() > 0) && (((awnf)localObject3).a == 1002L)) {
        axqy.b(null, "dc00898", "", "", "0X800A339", "0X800A339", 2, 0, "", "", "", "");
      }
      break label572;
      this.a.jdField_b_of_type_JavaUtilList.addAll(paramString2);
      ActiveEntitySearchFragment.a(this.a, paramString3);
      ActiveEntitySearchFragment.a(this.a, paramList1);
      if (!paramBoolean1)
      {
        paramString3 = new ArrayList();
        paramString3.addAll(paramString2);
        awwa.a("sub_result", "load_result", new String[] { this.a.jdField_b_of_type_JavaLangString, awwa.a(paramString3), "", awwa.a("dynamic_tab_search.1", this.a.jdField_a_of_type_ArrayOfLong) });
      }
      paramString2 = this.a.jdField_a_of_type_JavaUtilList;
      boolean bool1;
      label892:
      boolean bool2;
      if (!paramBoolean1)
      {
        bool1 = true;
        awvv.a(paramString2, paramList, bool1, this.a.jdField_a_of_type_ArrayOfLong, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_b_of_type_JavaLangString);
        if (j != 0) {
          break label1347;
        }
        if ((this.a.getActivity() instanceof awip)) {}
        switch (((awip)this.a.getActivity()).a())
        {
        case 2: 
        default: 
          if (QLog.isColorLevel()) {
            QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.a.jdField_b_of_type_Int + "   newSearchIndex:" + this.a.jdField_a_of_type_Int + " result.size():" + j);
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
      int k;
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
          label1347:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult extension parse error! " + QLog.getStackTraceString(paramArrayOfByte));
          paramString3 = "";
          paramArrayOfByte = paramString2;
          paramString2 = paramString3;
          continue;
        }
        if (!paramBoolean2) {
          break label1662;
        }
        this.a.c.setVisibility(0);
        if ((this.a.jdField_a_of_type_ArrayOfLong == null) || (this.a.jdField_a_of_type_ArrayOfLong.length != 2)) {
          break label1662;
        }
        paramString3 = new ArrayList();
        paramList1 = this.a.jdField_a_of_type_ArrayOfLong;
        k = paramList1.length;
        i = 0;
        if (i >= k) {
          break label1618;
        }
        paramString3.add(Long.valueOf(paramList1[i]));
        i += 1;
        continue;
        bool1 = false;
        break;
        awwa.a("sub_result", "no_result", new String[] { this.a.jdField_b_of_type_JavaLangString, awwa.a(this.a.jdField_a_of_type_ArrayOfLong), "", awwa.a("dynamic_tab_search.1", paramArrayOfLong) });
        break label892;
        awwa.a("all_result", "exp_tab_empty", new String[] { this.a.jdField_b_of_type_JavaLangString, awwa.a(this.a.jdField_a_of_type_ArrayOfLong), "", awwa.a("dynamic_tab_search.1", paramArrayOfLong) });
        break label892;
        if ((this.a.jdField_a_of_type_ArrayOfByte != null) || (!(this.a.getActivity() instanceof awip))) {
          break label892;
        }
        paramString2 = (awip)this.a.getActivity();
        switch (paramString2.a())
        {
        case 2: 
        default: 
          break;
        case 1: 
          awwa.a("all_result", "exp_tab_page", new String[] { this.a.jdField_b_of_type_JavaLangString, awwa.a(this.a.jdField_b_of_type_JavaUtilList), "", awwa.a("UnifySearch.Unite", paramString2.a()) });
          break;
        case 3: 
          awwa.a("sub_result", "exp_result", new String[] { paramString2.a(), awwa.a(this.a.jdField_b_of_type_JavaUtilList), "", awwa.a("dynamic_tab_search.1", paramString2.a()) });
          break;
          if (QLog.isColorLevel()) {
            QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult extension is null");
          }
          bool1 = false;
          paramString2 = "";
          paramArrayOfByte = "";
        }
      }
      label1618:
      if ((paramString3.contains(Long.valueOf(1001L))) && (paramString3.contains(Long.valueOf(1002L)))) {
        this.a.c.setVisibility(8);
      }
      label1662:
      int m;
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
          QLog.d(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "activity is finished. in handleTabSearchResult.");
          return;
        }
        k = baxn.a(paramString3, 8.0F);
        m = baxn.a(paramString3, 10.0F);
        int n = baxn.a(paramString3, 2.0F);
        paramList1 = new GradientDrawable();
        paramList1.setCornerRadius(baxn.a(this.a.getActivity(), 15.0F));
        i = Color.parseColor("#E2E2E2");
        bool2 = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        if (bool2) {
          i = Color.parseColor("#5a86bb");
        }
        paramList1.setStroke(1, i);
        paramString4 = ActiveEntitySearchFragment.a(this.a).iterator();
        while (paramString4.hasNext())
        {
          localObject1 = (DynamicTabSearch.SubHotWord)paramString4.next();
          localObject2 = ((DynamicTabSearch.SubHotWord)localObject1).show_word.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject3 = new TextView(paramString3);
            localObject4 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject4).rightMargin = k;
            ((TextView)localObject3).setPadding(m, n, m, n);
            i = Color.parseColor("#000000");
            if (bool2) {
              i = Color.parseColor("#5a86bb");
            }
            ((TextView)localObject3).setTextColor(i);
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
              ((TextView)localObject3).setTag(2131367633, localObject1);
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
            break label2628;
          }
          paramString2 = awiw.a(paramList, paramBoolean1, this.a.jdField_f_of_type_Boolean);
          if ((paramBoolean1) || (l1 != ActiveEntitySearchFragment.a(this.a)) || (paramBoolean3) || (paramString2 == null) || (paramString2.size() <= 0)) {
            break label2428;
          }
          paramArrayOfByte = (awog)this.a.jdField_a_of_type_JavaUtilList.get(this.a.jdField_a_of_type_JavaUtilList.size() - 1);
          paramString2.remove(0);
          k = 0;
          i = 0;
          label2222:
          if (i >= paramString2.size()) {
            break label3390;
          }
          if (!((awog)paramString2.get(i) instanceof awnp)) {
            break label2415;
          }
        }
      }
      for (;;)
      {
        if ((paramArrayOfByte instanceof awoi))
        {
          paramArrayOfByte = (awoi)paramArrayOfByte;
          k = paramArrayOfByte.a();
          awwd.a(paramArrayOfByte, k + i, k - 1);
        }
        for (;;)
        {
          m = 0;
          for (;;)
          {
            if (m < i)
            {
              paramArrayOfByte = (awog)paramString2.get(m);
              if ((paramArrayOfByte instanceof awoi)) {
                awwd.a((awoi)paramArrayOfByte, k + i, k + m);
              }
              m += 1;
              continue;
              if (((this.a.jdField_a_of_type_JavaUtilList == null) || (this.a.jdField_a_of_type_JavaUtilList.isEmpty())) && ((paramList == null) || (paramList.isEmpty()))) {
                break;
              }
              this.a.jdField_d_of_type_AndroidViewView.setVisibility(0);
              break;
              this.a.jdField_d_of_type_AndroidViewView.setVisibility(8);
              break;
              label2415:
              k = i;
              i += 1;
              break label2222;
            }
          }
          label2428:
          this.a.jdField_a_of_type_JavaUtilList.addAll(paramString2);
          this.a.jdField_a_of_type_Awkl.a(this.a.jdField_a_of_type_JavaUtilList);
          ActiveEntitySearchFragment.a(this.a, l2);
          if (!this.a.jdField_d_of_type_Boolean)
          {
            paramString2 = this.a;
            paramString2.jdField_b_of_type_Int += j;
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
            label2538:
            if (!paramBoolean2) {
              break label3301;
            }
            if (QLog.isColorLevel()) {
              QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult isEnd = true mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString + "  fragmentMask=" + Arrays.toString(this.a.jdField_a_of_type_ArrayOfLong));
            }
          }
          for (;;)
          {
            ActiveEntitySearchActivity.a = true;
            return;
            label2628:
            if ((paramList == null) || (paramList.isEmpty()))
            {
              this.a.g.setVisibility(0);
              paramString3 = (akaa)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
              if ((!bool1) && (paramString3.jdField_d_of_type_Boolean)) {
                if (this.a.jdField_a_of_type_Afdd == null)
                {
                  this.a.jdField_a_of_type_Afdd = new afdh(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.getActivity(), this.a.jdField_b_of_type_ComTencentWidgetXListView, null);
                  paramString2 = this.a.jdField_a_of_type_Afdd.a();
                  paramArrayOfByte = new TextView(this.a.getActivity());
                  paramArrayOfByte.setGravity(17);
                  paramArrayOfByte.setLayoutParams(new AbsListView.LayoutParams(-1, actj.a(105.0F, this.a.getResources())));
                  paramArrayOfByte.setTextColor(this.a.getResources().getColor(2131166931));
                  paramArrayOfByte.setTextSize(1, 17.0F);
                  paramArrayOfByte.setText(ajya.a(2131699782));
                  paramArrayOfByte.setBackgroundResource(2130838515);
                  paramString2.addHeaderView(paramArrayOfByte);
                  paramArrayOfByte = new TextView(this.a.getActivity());
                  paramArrayOfByte.setTextColor(this.a.getResources().getColor(2131166931));
                  paramArrayOfByte.setTextSize(1, 14.0F);
                  paramArrayOfByte.setGravity(16);
                  paramArrayOfByte.setPadding(actj.a(15.0F, this.a.getResources()), 0, 0, 0);
                  paramArrayOfByte.setLayoutParams(new AbsListView.LayoutParams(-1, actj.a(40.0F, this.a.getResources())));
                  paramArrayOfByte.setText(ajya.a(2131699780));
                  paramArrayOfByte.setBackgroundResource(2130838515);
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
                label2965:
                label2976:
                paramString2 = awiw.a(paramList, paramBoolean1, this.a.jdField_f_of_type_Boolean);
                this.a.jdField_a_of_type_JavaUtilList = paramString2;
                this.a.jdField_a_of_type_Awkl.a(this.a.jdField_a_of_type_JavaUtilList);
                break;
                this.a.jdField_a_of_type_Afdd.b();
                break label2965;
                this.a.jdField_b_of_type_ComTencentWidgetXListView.setVisibility(8);
                if (this.a.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
                try
                {
                  if (this.a.isAdded())
                  {
                    this.a.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.a.getResources(), 2130841820);
                    this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.jdField_a_of_type_AndroidGraphicsBitmap);
                  }
                  this.a.jdField_b_of_type_AndroidWidgetTextView.setText(ajya.a(2131699773));
                  if (bool1)
                  {
                    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
                    this.a.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new awkr(this, paramString2));
                    if (TextUtils.isEmpty(paramArrayOfByte)) {
                      break label2976;
                    }
                    this.a.jdField_a_of_type_AndroidWidgetButton.setText(paramArrayOfByte);
                    this.a.jdField_b_of_type_AndroidWidgetTextView.setPadding(0, baxn.a(this.a.jdField_b_of_type_AndroidWidgetTextView.getContext(), 15.0F), 0, 0);
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
              break label2976;
              this.a.g.setVisibility(8);
            }
            if (this.a.jdField_a_of_type_Int >= 3)
            {
              this.a.jdField_d_of_type_Boolean = true;
              break label2538;
            }
            this.a.b(this.a.jdField_b_of_type_JavaLangString);
            break label2538;
            label3301:
            if (QLog.isColorLevel()) {
              QLog.i(ActiveEntitySearchFragment.jdField_a_of_type_JavaLangString, 2, "handleTabSearchResult isEnd = false mask;" + Arrays.toString(paramArrayOfLong) + " key=" + paramString1 + " name=" + this.a.jdField_e_of_type_JavaLangString + "  fragmentMask=" + Arrays.toString(this.a.jdField_a_of_type_ArrayOfLong));
            }
          }
          k = 0;
        }
        label3390:
        i = k;
      }
      label3397:
      break label510;
      label3400:
      break label572;
      label3403:
      l3 = l2;
      i = j;
      l2 = l1;
      l1 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkq
 * JD-Core Version:    0.7.0.1
 */