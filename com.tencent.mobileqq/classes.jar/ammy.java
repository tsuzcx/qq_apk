import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ammy
  extends BaseAdapter
{
  static LRULinkedHashMap<String, URLDrawable> jdField_a_of_type_ComTencentUtilLRULinkedHashMap = new LRULinkedHashMap(15);
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  bljm jdField_a_of_type_Bljm;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  List<Object> jdField_a_of_type_JavaUtilList;
  public boolean a;
  final int b;
  final int c = 1;
  final int d = 2;
  final int e = 3;
  int f;
  int g;
  int h;
  int i;
  int j = 4;
  int k;
  int l;
  int m;
  int n;
  
  public ammy(Context paramContext, View.OnClickListener paramOnClickListener, bljm parambljm, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Bljm = parambljm;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = paramInt2;
    this.i = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    this.g = ((this.jdField_a_of_type_Int - this.i * (this.j + 1)) / this.j);
    this.h = (this.g * 176 / 150);
    this.k = (this.g - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.l = (this.h - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List<bhwj> paramList, List<bhwh> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(paramList1);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(this.jdField_a_of_type_JavaLangString);
    if (paramList != null)
    {
      this.jdField_a_of_type_Long = paramList.pendantId;
      this.m = paramList.faceId;
    }
    super.notifyDataSetChanged();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    List localList = akng.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i1 = 0;
      if (i1 < localList.size())
      {
        Object localObject1 = (aknh)localList.get(i1);
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561960, null);
        Object localObject2 = (ImageView)localView.findViewById(2131363137);
        TextView localTextView1 = (TextView)localView.findViewById(2131365655);
        TextView localTextView2 = (TextView)localView.findViewById(2131365653);
        ImageView localImageView = (ImageView)localView.findViewById(2131378269);
        if (!TextUtils.isEmpty(((aknh)localObject1).jdField_a_of_type_JavaLangString)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((aknh)localObject1).jdField_a_of_type_JavaLangString));
        }
        localTextView1.setText(((aknh)localObject1).c);
        localTextView2.setText(((aknh)localObject1).d);
        switch (((aknh)localObject1).jdField_b_of_type_Int)
        {
        case 1: 
        case 2: 
        case 3: 
        default: 
          localImageView.setVisibility(8);
        }
        for (;;)
        {
          if (localImageView.getVisibility() == 0)
          {
            localObject2 = localImageView.getDrawable();
            if (localObject2 != null) {
              localImageView.setLayoutParams(new LinearLayout.LayoutParams(((Drawable)localObject2).getIntrinsicWidth(), ((Drawable)localObject2).getIntrinsicHeight()));
            }
          }
          localView.setOnClickListener(new ammz(this, (aknh)localObject1, i1));
          localView.addOnLayoutChangeListener(new amna(this));
          if (i1 != 0) {
            localView.findViewById(2131377922).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, agej.a(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
          break;
          localImageView.setImageResource(2130847069);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130847070);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838574);
          localImageView.setVisibility(0);
          continue;
          localImageView.setVisibility(8);
        }
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > 0) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    if ((this.jdField_a_of_type_JavaUtilList.get(paramInt - 1) instanceof bhwj)) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i2 = 1;
    Object localObject1;
    if ((paramInt >= getCount()) || (paramInt < 0))
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
    int i1 = getItemViewType(paramInt);
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new amnf(this);
      if (i1 == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561963, paramViewGroup, false);
        localObject2 = paramView.findViewById(2131380375);
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).height = this.f;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366098));
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380376);
        b();
        paramView.setTag(localObject1);
      }
    }
    label147:
    label1965:
    label1990:
    label2130:
    label2136:
    for (;;)
    {
      ((amnf)localObject1).jdField_a_of_type_Int = paramInt;
      bhwj localbhwj;
      if (i1 == 1)
      {
        localbhwj = (bhwj)getItem(paramInt);
        ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setTag(localbhwj);
        if (localbhwj.c != null)
        {
          if (localbhwj.c.equals("1"))
          {
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847457));
          }
        }
        else
        {
          label231:
          if (localbhwj.jdField_a_of_type_JavaLangString != null)
          {
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localbhwj.jdField_a_of_type_JavaLangString + "(" + localbhwj.jdField_a_of_type_JavaUtilList.size() + ")");
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localbhwj.jdField_a_of_type_JavaLangString);
          }
          ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbhwj.jdField_b_of_type_Int));
          switch (localbhwj.jdField_b_of_type_Int)
          {
          default: 
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label378:
            if ((localbhwj.e != null) && (localbhwj.e.equals("actLiTpl")))
            {
              if (localbhwj.jdField_a_of_type_JavaLangString == null) {
                break label2130;
              }
              ((amnf)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(localbhwj.jdField_a_of_type_JavaLangString);
              ((amnf)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localbhwj.jdField_a_of_type_JavaLangString);
              ((amnf)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            break;
          }
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (localbhwj.jdField_b_of_type_JavaLangString != null)
        {
          ((amnf)localObject1).d.setText(localbhwj.jdField_b_of_type_JavaLangString);
          ((amnf)localObject1).d.setVisibility(0);
          i1 = i2;
        }
        for (;;)
        {
          if (i1 != 0)
          {
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            ((amnf)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((amnd)((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.a()).a(localbhwj);
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localbhwj.jdField_a_of_type_Int));
            ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbhwj.jdField_a_of_type_Int));
            if ((localbhwj.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localbhwj.e != null) && (!localbhwj.e.equals("")))) {
              break label1990;
            }
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localbhwj.jdField_a_of_type_Boolean) {
              break label1965;
            }
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131694575);
            ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849772);
            if (paramInt != getCount() - 1) {
              break label2013;
            }
            ((amnf)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
          for (;;)
          {
            localObject1 = paramView;
            break;
            if (i1 == 1)
            {
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561962, paramViewGroup, false);
              ((amnf)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372381));
              ((amnf)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372385));
              ((amnf)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372387));
              ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372386));
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131372374));
              ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372379));
              ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372378));
              ((amnf)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372365));
              ((amnf)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372367));
              ((amnf)localObject1).d = ((TextView)paramView.findViewById(2131372366));
              ((amnf)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365642);
              localObject2 = new amnd(this);
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject2);
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bljm);
              ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
              ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramView.setTag(localObject1);
              break label147;
            }
            if (i1 != 2) {
              break label2136;
            }
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561957, paramViewGroup, false);
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366244));
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366262));
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366264));
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366263));
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131374869));
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366242));
            ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366241));
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366218));
            ((amnf)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366220));
            ((amnf)localObject1).d = ((TextView)paramView.findViewById(2131366219));
            ((amnf)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365642);
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new amnb(this));
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131699794) + AvatarPendantManager.jdField_a_of_type_Int + ")");
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_Bljm);
            ((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            break label147;
            localObject1 = (amnf)paramView.getTag();
            break label147;
            if (localbhwj.c.equals("3"))
            {
              ((amnf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              ((amnf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847456));
              break label231;
            }
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label231;
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847070));
            break label378;
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847069));
            break label378;
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847458));
            break label378;
            File localFile = new File(bhkt.c + "/free.png");
            if (localFile.exists())
            {
              ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject3 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_free.png");
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject3;
                if (((URLDrawable)localObject3).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_free.png", localObject3);
                  localObject2 = localObject3;
                }
              }
              ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label378;
            localFile = new File(bhkt.c + "/rare.png");
            if (localFile.exists())
            {
              ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
              localObject3 = (URLDrawable)jdField_a_of_type_ComTencentUtilLRULinkedHashMap.get("key_rare.png");
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                localObject2 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
                localObject3 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject2);
                localObject2 = localObject3;
                if (((URLDrawable)localObject3).getStatus() == 1)
                {
                  jdField_a_of_type_ComTencentUtilLRULinkedHashMap.put("key_rare.png", localObject3);
                  localObject2 = localObject3;
                }
              }
              ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label378;
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847464));
            break label378;
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847463));
            break label378;
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label513;
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((amnf)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label513;
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131716129);
            ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849775);
            break label645;
            ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            break label645;
            label2013:
            ((amnf)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            continue;
            if (i1 == 2)
            {
              localObject2 = (List)getItem(paramInt);
              ((amnb)((amnf)localObject1).jdField_a_of_type_ComTencentWidgetGridView.a()).a((List)localObject2);
              if (((List)localObject2).size() == 8)
              {
                ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(anzj.a(2131699781));
              }
              else
              {
                ((amnf)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                ((amnf)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
              }
            }
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammy
 * JD-Core Version:    0.7.0.1
 */