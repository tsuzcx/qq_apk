import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aphn
  implements View.OnTouchListener
{
  private static aphn jdField_a_of_type_Aphn;
  public static boolean a;
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aphp(this);
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private DataReportViewer jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer;
  private ArrayList<apgp> jdField_a_of_type_JavaUtilArrayList;
  private HashMap<String, aphq> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean b;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  public static aphn a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 46	aphn:jdField_a_of_type_Aphn	Laphn;
    //   6: ifnonnull +19 -> 25
    //   9: ldc 2
    //   11: monitorenter
    //   12: new 2	aphn
    //   15: dup
    //   16: invokespecial 47	aphn:<init>	()V
    //   19: putstatic 46	aphn:jdField_a_of_type_Aphn	Laphn;
    //   22: ldc 2
    //   24: monitorexit
    //   25: ldc 2
    //   27: monitorexit
    //   28: getstatic 46	aphn:jdField_a_of_type_Aphn	Laphn;
    //   31: areturn
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	5	0	localObject1	Object
    //   38	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	25	32	finally
    //   33	36	32	finally
    //   3	12	38	finally
    //   25	28	38	finally
    //   36	38	38	finally
    //   39	42	38	finally
  }
  
  public ArrayList<apgp> a()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
      localObject1 = BaseApplication.getContext().getFileStreamPath("DataReportConfigs");
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        localObject1 = bdhb.a((File)localObject1);
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (TextUtils.isEmpty(((JSONObject)localObject2).optString("group")))
          {
            localObject2 = aphq.a((JSONObject)localObject2);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            this.jdField_a_of_type_JavaUtilHashMap.put(((aphq)localObject2).b, localObject2);
          }
          else
          {
            localObject2 = aphr.a((JSONObject)localObject2);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            localObject2 = ((aphr)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
            if (((Iterator)localObject2).hasNext())
            {
              aphq localaphq = (aphq)((Iterator)localObject2).next();
              this.jdField_a_of_type_JavaUtilHashMap.put(localaphq.b, localaphq);
              continue;
            }
          }
        }
        else
        {
          return this.jdField_a_of_type_JavaUtilArrayList;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      i += 1;
    }
  }
  
  public void a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localBaseApplication.getSystemService("window"));
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer = new apho(this, localBaseApplication, localBaseApplication);
      this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.setOnTouchListener(this);
    }
    if (!this.b) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer);
      label66:
      int i;
      if (Build.VERSION.SDK_INT >= 26) {
        i = 2038;
      }
      for (;;)
      {
        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
        localLayoutParams.gravity = 51;
        localLayoutParams.x = 0;
        localLayoutParams.y = bdaq.a(localBaseApplication, 72.0F);
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, localLayoutParams);
          this.b = true;
          return;
          i = 2003;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QQToast.a(localBaseApplication, 1, alud.a(2131703156), 0).a();
          }
        }
      }
    }
    catch (Exception localException2)
    {
      break label66;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    this.d = paramBoolean;
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putBoolean("DataReportViewerFloatViewHelper", paramBoolean);
    paramContext.apply();
  }
  
  public void a(apgp paramapgp)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramapgp);
    e();
    if ((paramapgp instanceof aphq)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(((aphq)paramapgp).b, (aphq)paramapgp);
    }
  }
  
  public void a(ArrayList<apgp> paramArrayList)
  {
    int k = 0;
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (apgp)((Iterator)localObject1).next();
      localHashMap.put(((apgp)localObject2).jdField_a_of_type_JavaLangString, Boolean.valueOf(((apgp)localObject2).jdField_a_of_type_Boolean));
    }
    int i = 0;
    int j = k;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (apgp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      j = i;
      if (!((apgp)localObject1).a())
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        i -= 1;
        if (!(localObject1 instanceof aphq)) {
          break label150;
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove(((aphq)localObject1).b);
        j = i;
      }
      label150:
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (!(localObject1 instanceof aphr));
      localObject1 = ((aphr)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (aphq)((Iterator)localObject1).next();
        this.jdField_a_of_type_JavaUtilHashMap.remove(((aphq)localObject2).b);
      }
    }
    if (j < paramArrayList.size())
    {
      localObject1 = (apgp)paramArrayList.get(j);
      if (localHashMap.containsKey(((apgp)localObject1).jdField_a_of_type_JavaLangString))
      {
        ((apgp)localObject1).jdField_a_of_type_Boolean = ((Boolean)localHashMap.get(((apgp)localObject1).jdField_a_of_type_JavaLangString)).booleanValue();
        label265:
        if (!(localObject1 instanceof aphq)) {
          break label310;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(((aphq)localObject1).b, (aphq)localObject1);
      }
      for (;;)
      {
        j += 1;
        break;
        ((apgp)localObject1).jdField_a_of_type_Boolean = true;
        break label265;
        label310:
        if ((localObject1 instanceof aphr))
        {
          localObject1 = ((aphr)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aphq)((Iterator)localObject1).next();
            this.jdField_a_of_type_JavaUtilHashMap.put(((aphq)localObject2).b, localObject2);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    e();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public void b()
  {
    if (this.b) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer);
      label20:
      this.b = false;
      return;
    }
    catch (Exception localException)
    {
      break label20;
    }
  }
  
  public void b(apgp paramapgp)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramapgp);
    e();
    if ((paramapgp instanceof aphq)) {
      this.jdField_a_of_type_JavaUtilHashMap.remove(((aphq)paramapgp).b);
    }
    for (;;)
    {
      return;
      if ((paramapgp instanceof aphr))
      {
        paramapgp = ((aphr)paramapgp).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramapgp.hasNext())
        {
          aphq localaphq = (aphq)paramapgp.next();
          this.jdField_a_of_type_JavaUtilHashMap.remove(localaphq.b);
        }
      }
    }
  }
  
  public void c()
  {
    this.d = true;
    IntentFilter localIntentFilter = new IntentFilter("action.data.report.viewer");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    a(BaseApplicationImpl.getApplication(), true);
  }
  
  public void d()
  {
    this.d = false;
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    b();
    a(BaseApplicationImpl.getApplication(), false);
  }
  
  public void e()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((apgp)localIterator.next()).a());
    }
    bdhb.a(BaseApplication.getContext().getFileStreamPath("DataReportConfigs").getAbsolutePath(), localJSONArray.toString());
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getContext();
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    if (i == 0) {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getY());
    }
    label146:
    do
    {
      return false;
      if (i == 2)
      {
        if ((this.c) || (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Int) > bdaq.a(paramView, 10.0F)))
        {
          this.c = true;
          paramMotionEvent = (WindowManager.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getLayoutParams();
          paramMotionEvent.y = (j - this.jdField_a_of_type_Int - xin.b(paramView, 0.0F));
          i = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight();
          if (paramMotionEvent.y >= 0) {
            break label146;
          }
          paramMotionEvent.y = 0;
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer, paramMotionEvent);
          return true;
          if (paramMotionEvent.y > i - this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getHeight()) {
            paramMotionEvent.y = (i - this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer.getHeight());
          }
        }
      }
    } while ((i != 1) && (i != 3));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphn
 * JD-Core Version:    0.7.0.1
 */