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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class amgs
  extends BaseAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = 0;
  protected amgw a;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected View.OnClickListener a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private ArrayList<Object> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<DiscussionInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  protected boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new amgu(this);
  private List<Entity> jdField_b_of_type_JavaUtilList = new ArrayList();
  public boolean b;
  
  public amgs(Context paramContext, amgw paramamgw, ListView paramListView, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new amgv(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    if (paramBoolean) {
      b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_Amgw = paramamgw;
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
      if ((localObject == null) || (!(localObject instanceof amgx))) {
        break label169;
      }
      localObject = (amgx)localObject;
      if ((paramString == null) && (!TextUtils.isEmpty(((amgx)localObject).jdField_a_of_type_JavaLangString)))
      {
        paramBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(101, ((amgx)localObject).jdField_a_of_type_JavaLangString);
        if (paramBitmap != null) {
          ((amgx)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        }
      }
    }
    label169:
    for (;;)
    {
      i += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(((amgx)localObject).jdField_a_of_type_JavaLangString, 101, true);
      continue;
      if (TextUtils.equals(paramString, ((amgx)localObject).jdField_a_of_type_JavaLangString))
      {
        ((amgx)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramBitmap));
        return;
      }
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
    Object localObject1 = new HashMap();
    Object localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719788);
    String str1 = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690989);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      long l = 0L;
      String str2 = ContactUtils.getDiscussionName(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
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
        if (StringUtil.isAsciiAlpha(str3.charAt(0))) {
          l |= str3.charAt(0);
        } else if (Character.isDigit(str3.charAt(0))) {
          l |= 0xFFFE;
        } else {
          l |= 0xFFFF;
        }
      }
    }
    Collections.sort(this.jdField_a_of_type_JavaUtilList, new amgt(this, (HashMap)localObject1));
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
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
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
    amgx localamgx;
    Object localObject;
    if (getItemViewType(paramInt) == 1) {
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559132, paramViewGroup, false);
        localamgx = new amgx(null);
        localamgx.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368381));
        localamgx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378659));
        localamgx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378661));
        localamgx.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365723));
        localamgx.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        localamgx.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
        localamgx.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView.setTag(localamgx);
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        ((Button)paramView.findViewById(2131365716)).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)getItem(paramInt);
        String str = localDiscussionInfo.uin;
        localObject = ContactUtils.getDiscussionName(this.jdField_a_of_type_AndroidContentContext, localDiscussionInfo);
        localamgx.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localObject = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        localamgx.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((antp)localObject).a(str)) }));
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(101, str);
        if (localObject != null) {
          break label345;
        }
        localamgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(bheg.e());
        label267:
        if (this.jdField_a_of_type_Int == 0) {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(str, 101, false);
        }
        localamgx.jdField_a_of_type_JavaLangString = str;
        localamgx.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = localDiscussionInfo;
        if (!this.jdField_a_of_type_Boolean) {
          break label372;
        }
        localamgx.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localamgx = (amgx)paramView.getTag();
      break;
      label345:
      localamgx.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentWidgetListView.getResources(), (Bitmap)localObject));
      break label267;
      label372:
      localamgx.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      continue;
      if (paramView == null)
      {
        localamgx = new amgx(null);
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559131, paramViewGroup, false);
        localamgx.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365739));
        paramView.setTag(localamgx);
      }
      for (;;)
      {
        localamgx.jdField_a_of_type_JavaLangString = "";
        if ((paramInt != 0) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
          break label483;
        }
        localamgx.jdField_a_of_type_AndroidWidgetTextView.setText(2131694176);
        break;
        localamgx = (amgx)paramView.getTag();
      }
      label483:
      localamgx.jdField_a_of_type_AndroidWidgetTextView.setText(2131694169);
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
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.resume();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.pause();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.cancelPendingRequests();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amgs
 * JD-Core Version:    0.7.0.1
 */