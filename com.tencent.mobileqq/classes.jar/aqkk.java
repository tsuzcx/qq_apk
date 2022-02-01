import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class aqkk
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<aqkg> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new LRULinkedHashMap(20);
  
  public aqkk(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = a();
  }
  
  private int a()
  {
    String str = aqkh.a();
    if (!TextUtils.isEmpty(str))
    {
      str = aqkd.a(str);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        aqkg localaqkg = (aqkg)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((str != null) && (str.equals(localaqkg.e()))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private static Drawable a(Context paramContext, String paramString)
  {
    paramString = aunb.a(paramContext, paramContext.getPackageManager().getApplicationInfo(paramString, 128).publicSourceDir);
    if (paramString != null) {
      return paramString;
    }
    return paramContext.getResources().getDrawable(2130844277);
  }
  
  @NotNull
  private aqkm a(View paramView)
  {
    aqkm localaqkm = new aqkm(null);
    localaqkm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368993));
    localaqkm.b = ((TextView)paramView.findViewById(2131378163));
    localaqkm.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368913));
    localaqkm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368862));
    localaqkm.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378637));
    return localaqkm;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView.setOnClickListener(new aqkl(this, paramInt));
  }
  
  private void a(int paramInt, aqkm paramaqkm)
  {
    long l = System.currentTimeMillis();
    aqkg localaqkg = (aqkg)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    b(paramInt, paramaqkm);
    b(paramaqkm, localaqkg);
    a(paramaqkm, localaqkg);
    a("bindIconView", l);
  }
  
  private void a(aqkm paramaqkm, aqkg paramaqkg)
  {
    Object localObject;
    if (!paramaqkg.a())
    {
      if (!TextUtils.isEmpty(paramaqkg.c()))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        paramaqkg = URLDrawable.getDrawable(paramaqkg.c(), (URLDrawable.URLDrawableOptions)localObject);
        paramaqkm.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramaqkg);
        return;
      }
      paramaqkm.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
      return;
    }
    for (;;)
    {
      try
      {
        localObject = paramaqkg.e();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
        {
          paramaqkg = (Drawable)this.jdField_a_of_type_JavaUtilMap.get(localObject);
          paramaqkm.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramaqkg);
          return;
        }
      }
      catch (Exception paramaqkm)
      {
        QLog.e("[BrowserOpt] RecommendBrowserAdapter", 1, "bindIconView: failed. ", paramaqkm);
        return;
      }
      paramaqkg = a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramaqkg);
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] RecommendBrowserAdapter", 2, new Object[] { paramString + " [cost] countTime: invoked. ", " ms: ", Long.valueOf(l - paramLong) });
    }
  }
  
  private void b(int paramInt, aqkm paramaqkm)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramaqkm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramaqkm.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b(aqkm paramaqkm, aqkg paramaqkg)
  {
    paramaqkm.jdField_a_of_type_AndroidWidgetTextView.setText(paramaqkg.a());
    paramaqkm.b.setText(paramaqkg.b());
    if (paramaqkg.a())
    {
      paramaqkm.b.setVisibility(8);
      paramaqkm.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
      paramaqkg = (LinearLayout.LayoutParams)paramaqkm.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramaqkg.setMargins(paramaqkg.leftMargin, 0, paramaqkg.rightMargin, paramaqkg.bottomMargin);
      paramaqkm.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramaqkg);
      return;
    }
    paramaqkm.b.setVisibility(0);
    paramaqkm.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    paramaqkg = (LinearLayout.LayoutParams)paramaqkm.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298200);
    paramaqkg.setMargins(paramaqkg.leftMargin, (int)f, paramaqkg.rightMargin, paramaqkg.bottomMargin);
    paramaqkm.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramaqkg);
  }
  
  @Nullable
  aqkg a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Int >= 0)) {
      return (aqkg)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(List<aqkg> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplication.context).inflate(2131561412, paramViewGroup, false);
      paramView = a(localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramInt, paramView);
      a(paramInt, localView, paramViewGroup);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      aqkm localaqkm = (aqkm)paramView.getTag();
      localView = paramView;
      paramView = localaqkm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkk
 * JD-Core Version:    0.7.0.1
 */