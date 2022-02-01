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

public class apdv
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<apdr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new LRULinkedHashMap(20);
  
  public apdv(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = a();
  }
  
  private int a()
  {
    String str = apds.a();
    if (!TextUtils.isEmpty(str))
    {
      str = apdo.a(str);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        apdr localapdr = (apdr)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((str != null) && (str.equals(localapdr.e()))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private static Drawable a(Context paramContext, String paramString)
  {
    paramString = aszl.a(paramContext, paramContext.getPackageManager().getApplicationInfo(paramString, 128).publicSourceDir);
    if (paramString != null) {
      return paramString;
    }
    return paramContext.getResources().getDrawable(2130844162);
  }
  
  @NotNull
  private apdx a(View paramView)
  {
    apdx localapdx = new apdx(null);
    localapdx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369019));
    localapdx.b = ((TextView)paramView.findViewById(2131377933));
    localapdx.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131368939));
    localapdx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368887));
    localapdx.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378401));
    return localapdx;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView.setOnClickListener(new apdw(this, paramInt));
  }
  
  private void a(int paramInt, apdx paramapdx)
  {
    long l = System.currentTimeMillis();
    apdr localapdr = (apdr)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    b(paramInt, paramapdx);
    b(paramapdx, localapdr);
    a(paramapdx, localapdr);
    a("bindIconView", l);
  }
  
  private void a(apdx paramapdx, apdr paramapdr)
  {
    Object localObject;
    if (!paramapdr.a())
    {
      if (!TextUtils.isEmpty(paramapdr.c()))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        paramapdr = URLDrawable.getDrawable(paramapdr.c(), (URLDrawable.URLDrawableOptions)localObject);
        paramapdx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramapdr);
        return;
      }
      paramapdx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
      return;
    }
    for (;;)
    {
      try
      {
        localObject = paramapdr.e();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
        {
          paramapdr = (Drawable)this.jdField_a_of_type_JavaUtilMap.get(localObject);
          paramapdx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramapdr);
          return;
        }
      }
      catch (Exception paramapdx)
      {
        QLog.e("[BrowserOpt] RecommendBrowserAdapter", 1, "bindIconView: failed. ", paramapdx);
        return;
      }
      paramapdr = a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramapdr);
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] RecommendBrowserAdapter", 2, new Object[] { paramString + " [cost] countTime: invoked. ", " ms: ", Long.valueOf(l - paramLong) });
    }
  }
  
  private void b(int paramInt, apdx paramapdx)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramapdx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramapdx.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b(apdx paramapdx, apdr paramapdr)
  {
    paramapdx.jdField_a_of_type_AndroidWidgetTextView.setText(paramapdr.a());
    paramapdx.b.setText(paramapdr.b());
    if (paramapdr.a())
    {
      paramapdx.b.setVisibility(8);
      paramapdx.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
      paramapdr = (LinearLayout.LayoutParams)paramapdx.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramapdr.setMargins(paramapdr.leftMargin, 0, paramapdr.rightMargin, paramapdr.bottomMargin);
      paramapdx.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramapdr);
      return;
    }
    paramapdx.b.setVisibility(0);
    paramapdx.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    paramapdr = (LinearLayout.LayoutParams)paramapdx.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298265);
    paramapdr.setMargins(paramapdr.leftMargin, (int)f, paramapdr.rightMargin, paramapdr.bottomMargin);
    paramapdx.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramapdr);
  }
  
  @Nullable
  apdr a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Int >= 0)) {
      return (apdr)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(List<apdr> paramList)
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
      localView = LayoutInflater.from(BaseApplication.context).inflate(2131561290, paramViewGroup, false);
      paramView = a(localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramInt, paramView);
      a(paramInt, localView, paramViewGroup);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      apdx localapdx = (apdx)paramView.getTag();
      localView = paramView;
      paramView = localapdx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdv
 * JD-Core Version:    0.7.0.1
 */