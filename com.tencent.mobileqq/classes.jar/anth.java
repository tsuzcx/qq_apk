import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class anth<T>
  extends BaseAdapter
{
  public int a;
  protected Context a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler;
  private LruCache<String, Drawable> jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(30);
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap<EmoticonPackage, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected List<T> a;
  JSONArray jdField_a_of_type_OrgJsonJSONArray;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public anth(Context paramContext, List<T> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838896);
    bboe.a((QQAppInterface)((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getAppRuntime(), bboe.d);
    paramContext = bboe.d.a(this.jdField_a_of_type_AndroidContentContext);
    if (paramContext != null) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONArray = paramContext.getJSONArray("wording");
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private Drawable a(EmoticonPackage paramEmoticonPackage)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramEmoticonPackage.epId) != null) {
      return (Drawable)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramEmoticonPackage.epId);
    }
    Drawable localDrawable = anqz.a(2, paramEmoticonPackage.epId);
    if (localDrawable != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramEmoticonPackage.epId, localDrawable);
      return localDrawable;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public List<EmoticonPackage> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Boolean)localEntry.getValue()).booleanValue()) {
        localArrayList.add(localEntry.getKey());
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    boolean bool = a(paramInt);
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (!bool) {}
    for (bool = true;; bool = false)
    {
      localHashMap.put(localEmoticonPackage, Boolean.valueOf(bool));
      return;
    }
  }
  
  public void a(T paramT)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((paramT instanceof EmoticonPackage))
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramT;
        this.jdField_a_of_type_JavaUtilHashMap.remove(localEmoticonPackage);
      }
      this.jdField_a_of_type_JavaUtilList.remove(paramT);
      if (this.b) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void a(T paramT, int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramInt, paramT);
      if (this.b) {
        notifyDataSetChanged();
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)getItem(paramInt);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localEmoticonPackage)) {
      return ((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localEmoticonPackage)).booleanValue();
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.evictAll();
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public T getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new anti(this);
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559049, null);
      ((anti)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365607));
      ((anti)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365612));
      ((anti)localObject).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365398));
      ((anti)localObject).d = ((ImageView)paramView.findViewById(2131365399));
      ((anti)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365611));
      ((anti)localObject).e = ((ImageView)paramView.findViewById(2131365608));
      ((anti)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365613));
      ((anti)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131375998);
      ((anti)localObject).jdField_b_of_type_AndroidViewView = paramView.findViewById(2131378661);
      ((anti)localObject).f = ((ImageView)paramView.findViewById(2131365609));
      ((anti)localObject).jdField_c_of_type_AndroidViewView = paramView.findViewById(2131365606);
      paramView.setTag(localObject);
      paramViewGroup.setTag(localObject);
      paramView.setBackgroundResource(2130839372);
      paramViewGroup = (ViewGroup)localObject;
      localObject = (EmoticonPackage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((EmoticonPackage)localObject).name);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a((EmoticonPackage)localObject));
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (!((EmoticonPackage)localObject).hasSound) {
        break label437;
      }
      paramViewGroup.e.setVisibility(0);
      if (!((EmoticonPackage)localObject).isNewVoiceType()) {
        break label424;
      }
      paramViewGroup.e.setImageResource(2130838117);
      label283:
      if (!this.jdField_a_of_type_Boolean) {
        break label503;
      }
      if (a(paramInt)) {
        break label449;
      }
      paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692260) + " " + ((EmoticonPackage)localObject).name);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846209);
      label349:
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      if (((EmoticonPackage)localObject).mobileFeetype != 4) {
        break label541;
      }
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.f.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839380));
      return paramView;
      paramViewGroup = (anti)paramView.getTag();
      break;
      label424:
      paramViewGroup.e.setImageResource(2130839381);
      break label283;
      label437:
      paramViewGroup.e.setVisibility(8);
      break label283;
      label449:
      paramView.setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131692248) + " " + ((EmoticonPackage)localObject).name);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846210);
      break label349;
      label503:
      paramView.setContentDescription(((EmoticonPackage)localObject).name);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    label541:
    if (((EmoticonPackage)localObject).mobileFeetype == 5)
    {
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.f.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846513));
      return paramView;
    }
    paramViewGroup.f.setVisibility(8);
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anth
 * JD-Core Version:    0.7.0.1
 */