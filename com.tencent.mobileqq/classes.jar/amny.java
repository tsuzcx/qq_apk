import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class amny
  extends BaseAdapter
  implements aoog, blih
{
  private int jdField_a_of_type_Int = 0;
  protected amoc a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected View.OnClickListener a;
  private aoof jdField_a_of_type_Aoof;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<DiscussionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new amoa(this);
  private List<Entity> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  
  public amny(Context paramContext, amoc paramamoc, ListView paramListView, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new amob(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    if (paramBoolean) {
      b();
    }
    this.jdField_a_of_type_Aoof = new aoof(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Amoc = paramamoc;
    paramListView.setOnScrollListener(this);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i).getTag();
      if ((localObject == null) || (!(localObject instanceof amod))) {
        break label169;
      }
      localObject = (amod)localObject;
      if ((paramString == null) && (!TextUtils.isEmpty(((amod)localObject).jdField_a_of_type_JavaLangString)))
      {
        paramBitmap = this.jdField_a_of_type_Aoof.a(101, ((amod)localObject).jdField_a_of_type_JavaLangString);
        if (paramBitmap != null) {
          ((amod)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        }
      }
    }
    label169:
    for (;;)
    {
      i += 1;
      break;
      this.jdField_a_of_type_Aoof.a(((amod)localObject).jdField_a_of_type_JavaLangString, 101, true);
      continue;
      if (TextUtils.equals(paramString, ((amod)localObject).jdField_a_of_type_JavaLangString))
      {
        ((amod)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = ((anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a();
    Object localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719080);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690864);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      long l = 0L;
      String str2 = bhlg.a(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
      String str3 = ChnToSpell.a(str2, 1);
      if ((str2.matches((String)localObject2)) || (str2.contains(str1))) {
        l = 65536L;
      }
      if ((str3 == null) || (str3.length() == 0)) {
        l |= 0xFFFF;
      }
      for (;;)
      {
        ((HashMap)localObject1).put(localDiscussionInfo.uin, Long.valueOf(l));
        break;
        if (bhsr.b(str3.charAt(0))) {
          l |= str3.charAt(0);
        } else if (Character.isDigit(str3.charAt(0))) {
          l |= 0xFFFE;
        } else {
          l |= 0xFFFF;
        }
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new amnz(this, (HashMap)localObject1));
    this.jdField_b_of_type_JavaUtilList.clear();
    localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      if (((DiscussionInfo)localObject2).hasCollect) {
        this.jdField_b_of_type_JavaUtilList.add(localObject2);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      int i = this.jdField_b_of_type_JavaUtilList.size();
      if (i > 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_b_of_type_JavaUtilList);
      }
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(i));
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public DiscussionInfo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (DiscussionInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Aoof.d();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    Object localObject = getItem(paramInt);
    if ((localObject instanceof DiscussionInfo)) {
      return Long.parseLong(((DiscussionInfo)localObject).uin);
    }
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((getItem(paramInt) instanceof Integer)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    amod localamod;
    Object localObject;
    if (getItemViewType(paramInt) == 1) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559096, paramViewGroup, false);
        localamod = new amod(null);
        localamod.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368212));
        localamod.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378604));
        localamod.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378606));
        localamod.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365597));
        localamod.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        localamod.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        localamod.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.setTag(localamod);
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((Button)paramView.findViewById(2131365590)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)getItem(paramInt);
        String str = localDiscussionInfo.uin;
        localObject = bhlg.a(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
        localamod.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localObject = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
        localamod.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((anws)localObject).a(str)) }));
        localObject = this.jdField_a_of_type_Aoof.a(101, str);
        if (localObject != null) {
          break label344;
        }
        localamod.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(bhmq.e());
        label266:
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_Aoof.a(str, 101, false);
        }
        localamod.jdField_a_of_type_JavaLangString = str;
        localamod.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = localDiscussionInfo;
        if (!this.jdField_a_of_type_Boolean) {
          break label371;
        }
        localamod.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localamod = (amod)paramView.getTag();
      break;
      label344:
      localamod.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentWidgetListView.getResources(), (Bitmap)localObject));
      break label266;
      label371:
      localamod.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      if (paramView == null)
      {
        localamod = new amod(null);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559095, paramViewGroup, false);
        localamod.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365613));
        paramView.setTag(localamod);
      }
      for (;;)
      {
        localamod.jdField_a_of_type_JavaLangString = "";
        if ((paramInt != 0) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
          break label482;
        }
        localamod.jdField_a_of_type_AndroidWidgetTextView.setText(2131693886);
        break;
        localamod = (amod)paramView.getTag();
      }
      label482:
      localamod.jdField_a_of_type_AndroidWidgetTextView.setText(2131693879);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void notifyDataSetChanged()
  {
    b();
    super.notifyDataSetChanged();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (this.jdField_a_of_type_Int == 0)) {
      a(paramString, paramBitmap);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 0)
    {
      a(null, null);
      this.jdField_a_of_type_Aoof.b();
      return;
    }
    this.jdField_a_of_type_Aoof.c();
    this.jdField_a_of_type_Aoof.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amny
 * JD-Core Version:    0.7.0.1
 */