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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class amfs
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
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  AdapterView.OnItemClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
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
  
  public amfs(Context paramContext, View.OnClickListener paramOnClickListener, AdapterView.OnItemClickListener paramOnItemClickListener, int paramInt1, QQAppInterface paramQQAppInterface, String paramString, int paramInt2)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.f = paramInt2;
    this.i = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F);
    this.g = ((this.jdField_a_of_type_Int - this.i * (this.j + 1)) / this.j);
    this.h = (this.g * 176 / 150);
    this.k = (this.g - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.l = (this.h - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentUtilLRULinkedHashMap.clear();
  }
  
  public void a(List<bhll> paramList, List<bhlj> paramList1)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.add(paramList1);
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    paramList = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
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
    List localList = akgt.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      int i1 = 0;
      if (i1 < localList.size())
      {
        Object localObject1 = (akgu)localList.get(i1);
        View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561905, null);
        Object localObject2 = (ImageView)localView.findViewById(2131363172);
        TextView localTextView1 = (TextView)localView.findViewById(2131365782);
        TextView localTextView2 = (TextView)localView.findViewById(2131365780);
        ImageView localImageView = (ImageView)localView.findViewById(2131378326);
        if (!TextUtils.isEmpty(((akgu)localObject1).jdField_a_of_type_JavaLangString)) {
          ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((akgu)localObject1).jdField_a_of_type_JavaLangString));
        }
        localTextView1.setText(((akgu)localObject1).c);
        localTextView2.setText(((akgu)localObject1).d);
        switch (((akgu)localObject1).jdField_b_of_type_Int)
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
          localView.setOnClickListener(new amft(this, (akgu)localObject1, i1));
          localView.addOnLayoutChangeListener(new amfu(this));
          if (i1 != 0) {
            localView.findViewById(2131377970).setVisibility(0);
          }
          localObject1 = new LinearLayout.LayoutParams(0, AIOUtils.dp2px(75.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject1);
          i1 += 1;
          break;
          localImageView.setImageResource(2130847074);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130847075);
          localImageView.setVisibility(0);
          continue;
          localImageView.setImageResource(2130838615);
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
    if ((this.jdField_a_of_type_JavaUtilList.get(paramInt - 1) instanceof bhll)) {
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
      localObject1 = new amfz(this);
      if (i1 == 0)
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561908, paramViewGroup, false);
        localObject2 = paramView.findViewById(2131380436);
        localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject3).height = this.f;
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366228));
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380437);
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
      ((amfz)localObject1).jdField_a_of_type_Int = paramInt;
      bhll localbhll;
      if (i1 == 1)
      {
        localbhll = (bhll)getItem(paramInt);
        ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setTag(localbhll);
        if (localbhll.c != null)
        {
          if (localbhll.c.equals("1"))
          {
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847454));
          }
        }
        else
        {
          label231:
          if (localbhll.jdField_a_of_type_JavaLangString != null)
          {
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(localbhll.jdField_a_of_type_JavaLangString + "(" + localbhll.jdField_a_of_type_JavaUtilList.size() + ")");
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setContentDescription(localbhll.jdField_a_of_type_JavaLangString);
          }
          ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbhll.jdField_b_of_type_Int));
          switch (localbhll.jdField_b_of_type_Int)
          {
          default: 
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            label378:
            if ((localbhll.e != null) && (localbhll.e.equals("actLiTpl")))
            {
              if (localbhll.jdField_a_of_type_JavaLangString == null) {
                break label2130;
              }
              ((amfz)localObject1).jdField_c_of_type_AndroidWidgetTextView.setText(localbhll.jdField_a_of_type_JavaLangString);
              ((amfz)localObject1).jdField_c_of_type_AndroidWidgetTextView.setContentDescription(localbhll.jdField_a_of_type_JavaLangString);
              ((amfz)localObject1).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            break;
          }
        }
      }
      for (i1 = 1;; i1 = 0)
      {
        if (localbhll.jdField_b_of_type_JavaLangString != null)
        {
          ((amfz)localObject1).d.setText(localbhll.jdField_b_of_type_JavaLangString);
          ((amfz)localObject1).d.setVisibility(0);
          i1 = i2;
        }
        for (;;)
        {
          if (i1 != 0)
          {
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
            ((amfz)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            ((amfx)((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a(localbhll);
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(localbhll.jdField_a_of_type_Int));
            ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(localbhll.jdField_a_of_type_Int));
            if ((localbhll.jdField_a_of_type_JavaUtilList.size() <= 4) || ((localbhll.e != null) && (!localbhll.e.equals("")))) {
              break label1990;
            }
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            if (localbhll.jdField_a_of_type_Boolean) {
              break label1965;
            }
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131694894);
            ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849782);
            if (paramInt != getCount() - 1) {
              break label2013;
            }
            ((amfz)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
          for (;;)
          {
            localObject1 = paramView;
            break;
            if (i1 == 1)
            {
              paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561907, paramViewGroup, false);
              ((amfz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372538));
              ((amfz)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372542));
              ((amfz)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372544));
              ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372543));
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131372531));
              ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372536));
              ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372535));
              ((amfz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131372522));
              ((amfz)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372524));
              ((amfz)localObject1).d = ((TextView)paramView.findViewById(2131372523));
              ((amfz)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365769);
              localObject2 = new amfx(this);
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter((ListAdapter)localObject2);
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
              ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
              ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
              paramView.setTag(localObject1);
              break label147;
            }
            if (i1 != 2) {
              break label2136;
            }
            paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561902, paramViewGroup, false);
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366375));
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366394));
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366396));
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366395));
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView = ((GridView)paramView.findViewById(2131374875));
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366373));
            ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366372));
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366350));
            ((amfz)localObject1).jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366352));
            ((amfz)localObject1).d = ((TextView)paramView.findViewById(2131366351));
            ((amfz)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365769);
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAdapter(new amfv(this));
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131700380) + AvatarPendantManager.jdField_a_of_type_Int + ")");
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setNumColumns(this.j);
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setColumnWidth(this.g);
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setHorizontalSpacing(this.i);
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setVerticalSpacing(this.i);
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setSelector(new ColorDrawable(0));
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setClickable(true);
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener);
            ((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.setAddStatesFromChildren(true);
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            paramView.setTag(localObject1);
            break label147;
            localObject1 = (amfz)paramView.getTag();
            break label147;
            if (localbhll.c.equals("3"))
            {
              ((amfz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              ((amfz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847453));
              break label231;
            }
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            break label231;
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847075));
            break label378;
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847074));
            break label378;
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847455));
            break label378;
            File localFile = new File(bhcs.c + "/free.png");
            if (localFile.exists())
            {
              ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
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
              ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label378;
            localFile = new File(bhcs.c + "/rare.png");
            if (localFile.exists())
            {
              ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
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
              ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
              break label378;
            }
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            break label378;
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847461));
            break label378;
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130847460));
            break label378;
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label513;
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
            ((amfz)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            break label513;
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(2131716724);
            ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130849785);
            break label645;
            ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            break label645;
            label2013:
            ((amfz)localObject1).jdField_a_of_type_AndroidViewView.setVisibility(0);
            continue;
            if (i1 == 2)
            {
              localObject2 = (List)getItem(paramInt);
              ((amfv)((amfz)localObject1).jdField_a_of_type_ComTencentWidgetGridView.getAdapter()).a((List)localObject2);
              if (((List)localObject2).size() == 8)
              {
                ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
                ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
                ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131700367));
              }
              else
              {
                ((amfz)localObject1).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
                ((amfz)localObject1).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
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
 * Qualified Name:     amfs
 * JD-Core Version:    0.7.0.1
 */