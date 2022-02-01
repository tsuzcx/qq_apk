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

public class aqgz
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<aqgv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new LRULinkedHashMap(20);
  
  public aqgz(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = a();
  }
  
  private int a()
  {
    String str = aqgw.a();
    if (!TextUtils.isEmpty(str))
    {
      str = aqgs.a(str);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        aqgv localaqgv = (aqgv)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((str != null) && (str.equals(localaqgv.e()))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private static Drawable a(Context paramContext, String paramString)
  {
    paramString = auds.a(paramContext, paramContext.getPackageManager().getApplicationInfo(paramString, 128).publicSourceDir);
    if (paramString != null) {
      return paramString;
    }
    return paramContext.getResources().getDrawable(2130844229);
  }
  
  @NotNull
  private aqhb a(View paramView)
  {
    aqhb localaqhb = new aqhb(null);
    localaqhb.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369182));
    localaqhb.b = ((TextView)paramView.findViewById(2131378221));
    localaqhb.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369100));
    localaqhb.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369045));
    localaqhb.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378692));
    return localaqhb;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView.setOnClickListener(new aqha(this, paramInt));
  }
  
  private void a(int paramInt, aqhb paramaqhb)
  {
    long l = System.currentTimeMillis();
    aqgv localaqgv = (aqgv)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    b(paramInt, paramaqhb);
    b(paramaqhb, localaqgv);
    a(paramaqhb, localaqgv);
    a("bindIconView", l);
  }
  
  private void a(aqhb paramaqhb, aqgv paramaqgv)
  {
    Object localObject;
    if (!paramaqgv.a())
    {
      if (!TextUtils.isEmpty(paramaqgv.c()))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        paramaqgv = URLDrawable.getDrawable(paramaqgv.c(), (URLDrawable.URLDrawableOptions)localObject);
        paramaqhb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramaqgv);
        return;
      }
      paramaqhb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
      return;
    }
    for (;;)
    {
      try
      {
        localObject = paramaqgv.e();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
        {
          paramaqgv = (Drawable)this.jdField_a_of_type_JavaUtilMap.get(localObject);
          paramaqhb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramaqgv);
          return;
        }
      }
      catch (Exception paramaqhb)
      {
        QLog.e("[BrowserOpt] RecommendBrowserAdapter", 1, "bindIconView: failed. ", paramaqhb);
        return;
      }
      paramaqgv = a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
      this.jdField_a_of_type_JavaUtilMap.put(localObject, paramaqgv);
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] RecommendBrowserAdapter", 2, new Object[] { paramString + " [cost] countTime: invoked. ", " ms: ", Long.valueOf(l - paramLong) });
    }
  }
  
  private void b(int paramInt, aqhb paramaqhb)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramaqhb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramaqhb.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b(aqhb paramaqhb, aqgv paramaqgv)
  {
    paramaqhb.jdField_a_of_type_AndroidWidgetTextView.setText(paramaqgv.a());
    paramaqhb.b.setText(paramaqgv.b());
    if (paramaqgv.a())
    {
      paramaqhb.b.setVisibility(8);
      paramaqhb.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
      paramaqgv = (LinearLayout.LayoutParams)paramaqhb.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramaqgv.setMargins(paramaqgv.leftMargin, 0, paramaqgv.rightMargin, paramaqgv.bottomMargin);
      paramaqhb.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramaqgv);
      return;
    }
    paramaqhb.b.setVisibility(0);
    paramaqhb.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    paramaqgv = (LinearLayout.LayoutParams)paramaqhb.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298268);
    paramaqgv.setMargins(paramaqgv.leftMargin, (int)f, paramaqgv.rightMargin, paramaqgv.bottomMargin);
    paramaqhb.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramaqgv);
  }
  
  @Nullable
  aqgv a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Int >= 0)) {
      return (aqgv)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(List<aqgv> paramList)
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
      localView = LayoutInflater.from(BaseApplication.context).inflate(2131561351, paramViewGroup, false);
      paramView = a(localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      a(paramInt, paramView);
      a(paramInt, localView, paramViewGroup);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      aqhb localaqhb = (aqhb)paramView.getTag();
      localView = paramView;
      paramView = localaqhb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgz
 * JD-Core Version:    0.7.0.1
 */