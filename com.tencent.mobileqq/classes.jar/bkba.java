import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bkba
{
  private bkbl jdField_a_of_type_Bkbl;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  private bkba(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  private ViewGroup.LayoutParams a(View paramView, bkbk parambkbk, JSONObject paramJSONObject)
  {
    if ((paramView == null) || (paramJSONObject == null) || (paramJSONObject.length() == 0) || (parambkbk == null)) {
      return null;
    }
    return this.jdField_a_of_type_Bkbl.a(paramView).a(paramJSONObject, parambkbk);
  }
  
  public static bkba a(@NonNull Context paramContext)
  {
    return new bkba(paramContext);
  }
  
  private final bkbk a(String paramString, Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      for (;;)
      {
        return null;
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("JsonInflater", 0, "createViewModel：" + paramString);
          }
          paramContext = this.jdField_a_of_type_Bkbl.a(paramContext, paramString);
          if (paramContext != null)
          {
            paramContext = this.jdField_a_of_type_Bkbl.a(paramString, paramContext);
            a(paramContext, paramJSONObject);
            return paramContext;
          }
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          QLog.e("JsonInflater", 1, "Error inflating type : " + paramString);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("JsonInflater", 0, "createViewModel fail finish");
    return null;
  }
  
  private bkbk a(JSONObject paramJSONObject, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramJSONObject == null) {}
    label103:
    do
    {
      return null;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("JsonInflater", 0, "inflate: ");
        }
        if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
          break label103;
        }
        paramJSONObject = new StringBuilder().append("inflate: weakContext == null ： ");
        paramBoolean = bool;
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          paramBoolean = true;
        }
        QLog.e("JsonInflater", 1, paramBoolean + " || weakContext.get() == null ");
        return null;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        QLog.e("JsonInflater", 1, "inflate: exception");
        paramJSONObject = null;
      }
      return paramJSONObject;
      localObject1 = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject1 == null);
    Object localObject2 = paramJSONObject.optString("type");
    if (QLog.isColorLevel()) {
      QLog.i("JsonInflater", 0, "Creating root view:");
    }
    localObject2 = a((String)localObject2, (Context)localObject1, paramJSONObject);
    if (localObject2 == null)
    {
      QLog.e("JsonInflater", 1, "inflate: createViewModel error null return");
      return null;
    }
    View localView = ((bkbk)localObject2).a();
    if (localView == null)
    {
      QLog.e("JsonInflater", 1, "inflate: tempView error null return");
      return null;
    }
    ViewGroup.LayoutParams localLayoutParams;
    if (paramViewGroup != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JsonInflater", 0, "generateLayoutParams");
      }
      localLayoutParams = a(paramViewGroup, (bkbk)localObject2, paramJSONObject);
      localObject1 = localLayoutParams;
      if (!paramBoolean)
      {
        localObject1 = localLayoutParams;
        if (localLayoutParams != null) {
          localView.setLayoutParams(localLayoutParams);
        }
      }
    }
    for (Object localObject1 = localLayoutParams;; localObject1 = null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("JsonInflater", 0, "-----> start inflating children");
      }
      a((bkbk)localObject2, localView.getContext(), paramJSONObject);
      if (QLog.isColorLevel()) {
        QLog.i("JsonInflater", 0, "-----> done inflating children");
      }
      paramJSONObject = (JSONObject)localObject2;
      if (paramViewGroup == null) {
        break;
      }
      paramJSONObject = (JSONObject)localObject2;
      if (!paramBoolean) {
        break;
      }
      paramViewGroup.addView(localView, (ViewGroup.LayoutParams)localObject1);
      ((bkbk)localObject2).a();
      paramJSONObject = (JSONObject)localObject2;
      break;
    }
  }
  
  public bkbk a(String paramString, ViewGroup paramViewGroup, boolean paramBoolean, bkbl parambkbl)
  {
    Object localObject3 = null;
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        if (localObject1 != null)
        {
          localObject1 = a((JSONObject)localObject1, paramViewGroup, paramBoolean, parambkbl);
          return localObject1;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        localObject2 = null;
        continue;
      }
      try
      {
        paramString = new JSONArray(paramString);
        localObject2 = localObject3;
        if (paramString == null) {
          continue;
        }
        return a(paramString, paramViewGroup, paramBoolean, parambkbl);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
    }
  }
  
  public bkbk a(String paramString, bkbl parambkbl)
  {
    return a(paramString, null, true, parambkbl);
  }
  
  public bkbk a(@NonNull JSONArray paramJSONArray, ViewGroup paramViewGroup, boolean paramBoolean, bkbl parambkbl)
  {
    this.jdField_a_of_type_Bkbl = parambkbl;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
    {
      paramJSONArray = new StringBuilder().append("inflate: weakContext == null ： ");
      if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.e("JsonInflater", 1, paramBoolean + " || weakContext.get() == null ");
        return null;
      }
    }
    paramViewGroup = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramViewGroup == null) {
      return null;
    }
    paramViewGroup = new RelativeLayout(paramViewGroup);
    parambkbl = this.jdField_a_of_type_Bkbl.a(paramViewGroup);
    int i = 0;
    while (i < paramJSONArray.length())
    {
      bkbk localbkbk = a(paramJSONArray.optJSONObject(i), paramViewGroup, false);
      if (localbkbk != null)
      {
        paramViewGroup.addView(localbkbk.a());
        localbkbk.a();
        parambkbl.a(localbkbk);
      }
      i += 1;
    }
    return parambkbl;
  }
  
  public bkbk a(@NonNull JSONObject paramJSONObject, ViewGroup paramViewGroup, boolean paramBoolean, bkbl parambkbl)
  {
    xmh.a();
    this.jdField_a_of_type_Bkbl = parambkbl;
    return a(paramJSONObject, paramViewGroup, paramBoolean);
  }
  
  void a(bkbk parambkbk, Context paramContext, JSONObject paramJSONObject)
  {
    if ((parambkbk == null) || (paramContext == null) || (paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("child");
    } while (paramJSONObject == null);
    int i = 0;
    label34:
    if (i < paramJSONObject.length())
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
      if (localJSONObject == null) {
        break label147;
      }
      bkbk localbkbk = a(localJSONObject.optString("type"), paramContext, localJSONObject);
      ViewGroup localViewGroup = (ViewGroup)parambkbk.a();
      ViewGroup.LayoutParams localLayoutParams = a(localViewGroup, localbkbk, localJSONObject);
      a(localbkbk, paramContext, localJSONObject);
      if ((localbkbk != null) && (localbkbk.a() != null))
      {
        localViewGroup.addView(localbkbk.a(), localLayoutParams);
        localbkbk.a();
        parambkbk.a(localbkbk);
      }
    }
    for (;;)
    {
      i += 1;
      break label34;
      break;
      label147:
      QLog.e("JsonInflater", 1, "rInflateChildren error: object = null");
    }
  }
  
  protected void a(bkbk parambkbk, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {
      return;
    }
    if (parambkbk != null) {
      parambkbk.a(paramJSONObject);
    }
    this.jdField_a_of_type_Bkbl.a(parambkbk, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkba
 * JD-Core Version:    0.7.0.1
 */