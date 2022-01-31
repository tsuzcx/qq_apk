import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.TMG.utils.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class bkbk
  implements Handler.Callback
{
  protected int a;
  protected Handler a;
  protected View a;
  private ArrayList<bkbk> a;
  protected int b;
  protected String c;
  
  public bkbk(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public bkbk(String paramString, View paramView)
  {
    this(paramView);
    this.c = paramString;
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Drawable localDrawable = a(paramString);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localDrawable);
      return;
    }
    throw new RuntimeException(getClass().getName() + " set background drawable = null not match value = " + paramString);
  }
  
  private int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -2;
      try
      {
        if ("fill".equals(paramString)) {
          return -1;
        }
        if (!"fit".equals(paramString))
        {
          int i = a(paramString);
          return i;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return -2;
  }
  
  protected int a()
  {
    return bdkf.a();
  }
  
  protected int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i;
      if (paramString.endsWith("w")) {
        i = Integer.parseInt(paramString.substring(0, paramString.indexOf("w"))) * a();
      }
      for (;;)
      {
        return i / 10000;
        if (paramString.endsWith("h"))
        {
          i = Integer.parseInt(paramString.substring(0, paramString.indexOf("h"))) * b();
        }
        else
        {
          i = Integer.parseInt(paramString);
          int j = a();
          i *= j;
        }
      }
      return 0;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("JsonInflateViewModel", 1, "getIntegerValue exception: value =  " + paramString);
    }
  }
  
  protected Drawable a(String paramString)
  {
    ColorDrawable localColorDrawable = null;
    if (paramString.startsWith("#")) {
      localColorDrawable = new ColorDrawable(Color.parseColor(paramString));
    }
    return localColorDrawable;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  protected ViewGroup.LayoutParams a(int paramInt1, int paramInt2)
  {
    return new ViewGroup.LayoutParams(paramInt1, paramInt2);
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    return paramLayoutParams;
  }
  
  public ViewGroup.LayoutParams a(JSONObject paramJSONObject, bkbk parambkbk)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return null;
    }
    Object localObject1 = paramJSONObject.optString("width");
    Object localObject2 = paramJSONObject.optString("height");
    this.jdField_a_of_type_Int = b((String)localObject1);
    this.b = b((String)localObject2);
    if (QLog.isColorLevel()) {
      QLog.i("JsonInflateViewModel", 0, "class = " + this.jdField_a_of_type_AndroidViewView.getClass().getSimpleName() + " width = " + this.jdField_a_of_type_Int + " height = " + this.b);
    }
    localObject1 = a(this.jdField_a_of_type_Int, this.b);
    localObject2 = paramJSONObject.keys();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      a(str, paramJSONObject.optString(str), (ViewGroup.LayoutParams)localObject1);
    }
    parambkbk.a((ViewGroup.LayoutParams)localObject1, paramJSONObject);
    return localObject1;
  }
  
  public bkbk a(String paramString)
  {
    bkbk localbkbk2 = null;
    bkbk localbkbk1 = localbkbk2;
    if (!TextUtils.isEmpty(this.c))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label25;
      }
      localbkbk1 = localbkbk2;
    }
    label25:
    do
    {
      return localbkbk1;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        if (this.c.equals(paramString)) {}
        for (paramString = this;; paramString = null) {
          return paramString;
        }
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      localbkbk1 = null;
      if (!localIterator.hasNext()) {
        break;
      }
      localbkbk2 = (bkbk)localIterator.next();
      if (localbkbk2 == null) {
        break label110;
      }
      localbkbk2 = localbkbk2.a(paramString);
      localbkbk1 = localbkbk2;
    } while (localbkbk2 != null);
    localbkbk1 = localbkbk2;
    label110:
    for (;;)
    {
      break;
      return localbkbk1;
    }
  }
  
  public void a() {}
  
  public void a(bkbk parambkbk)
  {
    if (parambkbk == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(parambkbk);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ("background_color".equals(paramString1))
    {
      a(paramString2);
      return;
    }
    if ("rotate".equals(paramString1))
    {
      this.jdField_a_of_type_AndroidViewView.setPivotX(0.0F);
      this.jdField_a_of_type_AndroidViewView.setPivotY(0.0F);
      this.jdField_a_of_type_AndroidViewView.setRotation(Float.parseFloat(paramString2));
      return;
    }
    if ("id".equals(paramString1))
    {
      this.jdField_a_of_type_AndroidViewView.setId(Integer.parseInt(paramString2));
      return;
    }
    QLog.e("JsonInflateViewModel", 1, this.c + " illegal attr :" + paramString1 + " = " + paramString2);
  }
  
  protected void a(String paramString1, String paramString2, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      if (!"x".equals(paramString1)) {
        break label30;
      }
      ((ViewGroup.MarginLayoutParams)paramLayoutParams).leftMargin = a(paramString2);
    }
    label30:
    while (!"y".equals(paramString1)) {
      return;
    }
    ((ViewGroup.MarginLayoutParams)paramLayoutParams).topMargin = a(paramString2);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a(str, paramJSONObject.optString(str));
    }
    b();
  }
  
  protected int b()
  {
    return bdkf.b();
  }
  
  protected void b() {}
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bkbk localbkbk = (bkbk)localIterator.next();
      if (localbkbk != null) {
        localbkbk.c();
      }
    }
  }
  
  public void e()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bkbk localbkbk = (bkbk)localIterator.next();
      if (localbkbk != null) {
        localbkbk.e();
      }
    }
  }
  
  public void f()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bkbk localbkbk = (bkbk)localIterator.next();
      if (localbkbk != null) {
        localbkbk.f();
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbk
 * JD-Core Version:    0.7.0.1
 */