import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lanht;>;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class anao
  extends BaseAdapter
  implements Handler.Callback, View.OnClickListener, behi, bejw
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private amzw jdField_a_of_type_Amzw;
  private volatile anav jdField_a_of_type_Anav;
  private Handler jdField_a_of_type_AndroidOsHandler;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  Button jdField_a_of_type_AndroidWidgetButton;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  IphoneTitleBarActivity jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  GestureSelectGridView jdField_a_of_type_ComTencentWidgetGestureSelectGridView;
  List<anht> jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  Button jdField_b_of_type_AndroidWidgetButton;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  public TextView b;
  List<anht> jdField_b_of_type_JavaUtilList = null;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -2147483648;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  private volatile boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 2147483647;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  private volatile int f = 0;
  
  public anao(QQAppInterface paramQQAppInterface, IphoneTitleBarActivity paramIphoneTitleBarActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = paramIphoneTitleBarActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramIphoneTitleBarActivity.getLayoutInflater();
    this.jdField_a_of_type_Float = paramIphoneTitleBarActivity.getApplicationContext().getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidOsHandler = new befq(Looper.getMainLooper(), this);
    this.jdField_e_of_type_Int = aciy.a(88.0F, paramIphoneTitleBarActivity.getResources());
  }
  
  private List<anht> a(List<anht> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = a();
    if ((paramList != null) && (paramList.size() > 0) && (localConcurrentHashMap.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        anht localanht = (anht)localIterator.next();
        if (localConcurrentHashMap.containsKey(Integer.valueOf(localanht.g))) {
          localanht.jdField_a_of_type_Boolean = true;
        }
      }
    }
    return paramList;
  }
  
  private ConcurrentHashMap<Integer, Boolean> a()
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        anht localanht = (anht)localIterator.next();
        if (localanht.jdField_a_of_type_Boolean) {
          localConcurrentHashMap.put(Integer.valueOf(localanht.g), Boolean.valueOf(true));
        }
      }
    }
    return localConcurrentHashMap;
  }
  
  private void a(anau paramanau)
  {
    paramanau.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramanau.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramanau.c.setVisibility(8);
    paramanau.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    Animatable localAnimatable = (Animatable)BaseApplication.getContext().getResources().getDrawable(2130839113);
    paramanau.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localAnimatable);
    localAnimatable.start();
    paramanau.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramanau.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramanau.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void a(anht paramanht, String paramString, anau paramanau)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramanau == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "updateViewStatus holder is null");
      }
    }
    do
    {
      return;
      paramanau.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(null);
      if (paramString.equals("needUpload"))
      {
        a(paramanau);
        return;
      }
      if (paramString.equals("failed"))
      {
        b(paramanau);
        return;
      }
      c(paramanau);
    } while (!(paramanht.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getBaseContext(), 0.0F, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int) instanceof URLDrawable));
    paramanau.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new anat(this, paramanht, paramanau));
    a(paramanau.jdField_a_of_type_ComTencentImageURLImageView, paramanau);
  }
  
  private void a(URLImageView paramURLImageView, anau paramanau)
  {
    if ((paramURLImageView.getDrawable() instanceof URLDrawable))
    {
      paramURLImageView = (URLDrawable)paramURLImageView.getDrawable();
      if (paramURLImageView.getStatus() == 0) {
        a(paramanau);
      }
    }
    else
    {
      return;
    }
    if ((paramURLImageView.getStatus() == 2) || (paramURLImageView.getStatus() == 3))
    {
      b(paramanau);
      return;
    }
    c(paramanau);
  }
  
  private boolean a(anht paramanht)
  {
    if ((paramanht instanceof ankl))
    {
      paramanht = (ankl)paramanht;
      if ((TextUtils.isEmpty(paramanht.g)) || (!paramanht.g.equals("failed"))) {}
    }
    do
    {
      return true;
      return false;
      if (!(paramanht instanceof anla)) {
        break;
      }
      paramanht = (anla)paramanht;
    } while ((!TextUtils.isEmpty(paramanht.a)) && (paramanht.a.equals("failed")));
    return false;
    return false;
  }
  
  private void b(anau paramanau)
  {
    paramanau.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramanau.jdField_b_of_type_AndroidViewView.setVisibility(0);
    paramanau.c.setVisibility(0);
    paramanau.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramanau.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramanau.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramanau.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(int paramInt)
  {
    if (this.f == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(2131626434);
    }
    while (this.f != 1) {
      return;
    }
    String str = String.format(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626431), new Object[] { Integer.valueOf(paramInt) });
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(str);
  }
  
  private void c(anau paramanau)
  {
    paramanau.jdField_a_of_type_AndroidViewView.setVisibility(8);
    paramanau.jdField_b_of_type_AndroidViewView.setVisibility(8);
    paramanau.c.setVisibility(8);
    paramanau.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    paramanau.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    if (this.f == 1)
    {
      paramanau.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramanau.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void d(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
      {
        localObject1 = (anht)this.jdField_b_of_type_JavaUtilList.get(paramInt);
        this.jdField_b_of_type_JavaUtilList.remove(paramInt);
      }
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (localObject1 != null))
    {
      this.jdField_a_of_type_JavaUtilList.remove(localObject1);
      anch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Integer.valueOf(((anht)localObject1).g));
    }
  }
  
  private void i()
  {
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    Object localObject3;
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      this.jdField_c_of_type_Boolean = true;
      localArrayList4 = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localObject2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localObject3 = new ArrayList();
      localObject1 = ((ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149)).a();
      localObject4 = this.jdField_b_of_type_JavaUtilList.iterator();
      for (;;)
      {
        label95:
        if (!((Iterator)localObject4).hasNext()) {
          break label292;
        }
        anht localanht = (anht)((Iterator)localObject4).next();
        if (localanht.jdField_a_of_type_Boolean)
        {
          localanht.jdField_a_of_type_Boolean = false;
          if (a(localanht)) {
            localArrayList2.add(localanht);
          }
          for (i = 1;; i = 0)
          {
            if (localObject1 == null) {
              break label255;
            }
            Iterator localIterator = ((List)localObject1).iterator();
            if (!localIterator.hasNext()) {
              break label95;
            }
            CustomEmotionData localCustomEmotionData = (CustomEmotionData)localIterator.next();
            if (localCustomEmotionData.emoId != localanht.g) {
              break;
            }
            if ((i == 0) && (!TextUtils.isEmpty(localCustomEmotionData.resid))) {
              localArrayList4.add(localCustomEmotionData.resid);
            }
            localArrayList1.add(localCustomEmotionData);
            break label95;
            localArrayList3.add(localanht);
          }
        }
        else
        {
          label255:
          if (a(localanht)) {
            ((List)localObject2).add(localanht);
          } else {
            ((List)localObject3).add(localanht);
          }
        }
      }
      label292:
      if ((localArrayList3.size() != 0) || (localArrayList2.size() != 0)) {
        break label328;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "handleEmotionMove selectedList is empty!");
      }
    }
    return;
    label328:
    Object localObject4 = (ajhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72);
    if (localObject4 != null) {
      ((ajhx)localObject4).a(localArrayList4);
    }
    ArrayList localArrayList4 = new ArrayList();
    if (localArrayList2.size() > 0) {
      localArrayList4.addAll(localArrayList2);
    }
    if (((List)localObject2).size() > 0) {
      localArrayList4.addAll((Collection)localObject2);
    }
    if (localArrayList3.size() > 0) {
      localArrayList4.addAll(localArrayList3);
    }
    if (((List)localObject3).size() > 0) {
      localArrayList4.addAll((Collection)localObject3);
    }
    d(localArrayList4);
    Object localObject2 = (ancg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
    int j = localArrayList1.size();
    Object localObject1 = ((List)localObject1).iterator();
    int i = 1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject3 = (CustomEmotionData)((Iterator)localObject1).next();
      if (i >= ((CustomEmotionData)localObject3).emoId) {
        break label653;
      }
      i = ((CustomEmotionData)localObject3).emoId;
    }
    label653:
    for (;;)
    {
      break;
      if (j > 0)
      {
        int k = j - 1;
        j = i;
        i = k;
        while (i >= 0)
        {
          localObject1 = (CustomEmotionData)localArrayList1.get(i);
          ((ancg)localObject2).a((CustomEmotionBase)localObject1);
          localObject1 = ((CustomEmotionData)localObject1).cloneEmotionData((CustomEmotionData)localObject1);
          j += 1;
          ((CustomEmotionData)localObject1).emoId = j;
          ((ancg)localObject2).c((CustomEmotionBase)localObject1);
          i -= 1;
        }
        ((ancg)localObject2).a();
      }
      i = localArrayList3.size();
      j = localArrayList2.size();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A6D3", "0X800A6D3", 0, 0, String.valueOf(i + j), "", "", "");
      return;
    }
  }
  
  private void j()
  {
    begr localbegr = (begr)behe.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, null);
    localbegr.a(2131626416);
    localbegr.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626808), 3);
    localbegr.c(2131625035);
    localbegr.a(new anap(this, localbegr));
    localbegr.show();
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((anht)localIterator.next()).jdField_a_of_type_Boolean = false;
    }
    notifyDataSetChanged();
    d();
  }
  
  private void l()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, NewPhotoListActivity.class);
    localIntent.putExtra("enter_from", 2);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 1);
    localIntent.putExtra("filter_photolist_troopalbum_toolbar", false);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("PhotoConst.IS_FROM_EMOTION_FAVORITE", true);
    localIntent.putExtra("peakconstant.request_code", 100015);
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.startActivityForResult(localIntent, 100015);
  }
  
  private void m()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      ((ajhx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(72)).notifyUI(2, true, null);
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    if (this.f == 0) {}
    do
    {
      do
      {
        return;
      } while (getCount() <= paramInt);
      localObject = getItem(paramInt);
    } while (!ankr.class.isInstance(localObject));
    Object localObject = (ankr)localObject;
    this.jdField_b_of_type_Boolean = ((ankr)localObject).a();
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      ((ankr)localObject).a(bool);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
      this.jdField_a_of_type_Boolean = true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavEmosmViewPage", 2, "onSelectBegin");
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.f == 0) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, new Object[] { "onSelectBegin beginIndex:", Integer.valueOf(paramInt1), "  selectIndex:", Integer.valueOf(paramInt2) });
    }
    int j;
    int i;
    if (paramInt2 < paramInt1)
    {
      j = paramInt1;
      i = paramInt2;
      if (this.jdField_d_of_type_Int > paramInt2)
      {
        this.jdField_d_of_type_Int = paramInt2;
        i = paramInt2;
        j = paramInt1;
      }
    }
    for (;;)
    {
      paramInt1 = i;
      for (;;)
      {
        if (paramInt1 > j) {
          break label174;
        }
        localObject = getItem(paramInt1);
        if (ankr.class.isInstance(localObject)) {
          break;
        }
        paramInt1 += 1;
      }
      if (this.jdField_c_of_type_Int < paramInt2) {
        this.jdField_c_of_type_Int = paramInt2;
      }
      j = paramInt2;
      i = paramInt1;
    }
    Object localObject = (ankr)localObject;
    if (!this.jdField_b_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      ((ankr)localObject).a(bool);
      break;
    }
    label174:
    paramInt1 = j + 1;
    if (paramInt1 <= this.jdField_c_of_type_Int)
    {
      localObject = getItem(paramInt1);
      if (!ankr.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((ankr)localObject).a(this.jdField_b_of_type_Boolean);
      }
    }
    paramInt1 = this.jdField_d_of_type_Int;
    if (paramInt1 < i)
    {
      localObject = getItem(paramInt1);
      if (!ankr.class.isInstance(localObject)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        ((ankr)localObject).a(this.jdField_b_of_type_Boolean);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.invalidateViews();
    d();
  }
  
  public void a(amzw paramamzw)
  {
    this.jdField_a_of_type_Amzw = paramamzw;
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources();
    int i = localResources.getDisplayMetrics().widthPixels;
    int j = aciy.a(0.0F, localResources);
    int k = aciy.a(4.0F, localResources);
    int m = aciy.a(4.0F, localResources);
    this.jdField_a_of_type_Int = ((i - j * 2 - k * 3) / 4);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_e_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.rightViewText;
    this.jdField_d_of_type_AndroidWidgetTextView = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.leftView;
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(2131626432);
    this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626433));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131299984));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131299986));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131299985));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131299995));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626423));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131304783));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131299993));
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(false);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131299994));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131299939));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(k);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(m);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(j, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), j, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setMaximumVelocity((int)(2500.0F * this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getResources().getDisplayMetrics().density));
    if ((paramamzw.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity)) && (paramamzw.jdField_a_of_type_Boolean))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131625271);
      if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.findViewById(2131297980));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((paramamzw.b()) || (bajr.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void a(anav paramanav)
  {
    this.jdField_a_of_type_Anav = paramanav;
  }
  
  public void a(GridView paramGridView, int paramInt)
  {
    if ((paramGridView == null) || (paramInt < 0)) {}
    int i;
    int j;
    do
    {
      return;
      i = paramGridView.getFirstVisiblePosition();
      j = paramGridView.getLastVisiblePosition();
    } while ((paramInt < i) || (paramInt > j));
    getView(paramInt, paramGridView.getChildAt(paramInt - i), paramGridView);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        anht localanht = (anht)localIterator.next();
        if (((localanht instanceof ankl)) && (TextUtils.isEmpty(((ankl)localanht).d)) && (((ankl)localanht).d.equals(paramString1))) {
          ((ankl)localanht).g = paramString2;
        }
      }
    }
  }
  
  public void a(List<anht> paramList)
  {
    if ((!this.jdField_a_of_type_Amzw.a()) && (paramList == null)) {
      return;
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    anch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
    if (this.f == 0) {
      if (this.jdField_a_of_type_Amzw.a())
      {
        if (((List)localObject).size() == 0)
        {
          paramList = new anht();
          paramList.f = 1;
          ((List)localObject).add(0, paramList);
        }
      }
      else
      {
        c((List)localObject);
        d((List)localObject);
      }
    }
    for (;;)
    {
      d();
      return;
      if (((anht)((List)localObject).get(0)).f == 1) {
        break;
      }
      paramList = new anht();
      paramList.f = 1;
      ((List)localObject).add(0, paramList);
      break;
      paramList = (List<anht>)localObject;
      if (a()) {
        paramList = a((List)localObject);
      }
      c(paramList);
      paramList = this.jdField_a_of_type_Amzw.a(paramList);
      if (paramList != null) {
        d(paramList);
      } else if (QLog.isColorLevel()) {
        QLog.d("FavEmosmViewPage", 2, "reloadFavEmotionFinished favEmoList is null");
      }
    }
  }
  
  public boolean a()
  {
    return this.f == 1;
  }
  
  public void b()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.setTitle(paramInt);
  }
  
  public void b(List<anht> paramList)
  {
    if (paramList == null) {
      return;
    }
    if ((this.jdField_a_of_type_Amzw.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_Amzw.jdField_a_of_type_JavaUtilList.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_Amzw.jdField_a_of_type_JavaUtilList);
    }
    Object localObject;
    if ((this.jdField_a_of_type_Amzw.a()) && (this.f == 0))
    {
      if (paramList.size() != 0) {
        break label139;
      }
      localObject = new anht();
      ((anht)localObject).f = 1;
      paramList.add(0, localObject);
    }
    for (;;)
    {
      anch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).h();
      localObject = paramList;
      if (a()) {
        localObject = a(paramList);
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      this.jdField_b_of_type_JavaUtilList = ((List)localObject);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this);
      d();
      return;
      label139:
      if (((anht)paramList.get(0)).f != 1)
      {
        localObject = new anht();
        ((anht)localObject).f = 1;
        paramList.add(0, localObject);
      }
    }
  }
  
  void c()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_b_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      anht localanht = (anht)((Iterator)localObject).next();
      if (localanht.jdField_a_of_type_Boolean) {
        localArrayList.add(localanht);
      }
    }
    if (localArrayList.isEmpty())
    {
      apcb.c(2131626941);
      return;
    }
    localObject = new aryh(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity);
    this.jdField_a_of_type_Amzw.a().a(new anaq(this, (aryh)localObject));
    this.jdField_a_of_type_Amzw.a().a(localArrayList);
  }
  
  public void c(List<anht> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  void d()
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    int i;
    if (getCount() > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#00a5e0"));
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      i = 0;
      label48:
      if (!localIterator.hasNext()) {
        break label103;
      }
      if (!((anht)localIterator.next()).jdField_a_of_type_Boolean) {
        break label267;
      }
      i += 1;
    }
    label267:
    for (;;)
    {
      break label48;
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(Color.parseColor("#cccccc"));
      break;
      label103:
      if (this.jdField_a_of_type_Amzw.jdField_a_of_type_Boolean)
      {
        if (i >= 0)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        return;
      }
      if (i > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(1.0F);
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
      for (;;)
      {
        c(i);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626415));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_b_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_c_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.3F);
      }
    }
  }
  
  public void d(List<anht> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Amzw.a(new anas(this));
  }
  
  void f()
  {
    if (this.jdField_a_of_type_Amzw != null) {
      this.jdField_a_of_type_Amzw.g();
    }
  }
  
  public void g()
  {
    if (this.f == 0) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = -2147483648;
    this.jdField_d_of_type_Int = 2147483647;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmViewPage", 2, "onSelectEnd");
    }
    d();
  }
  
  public int getCount()
  {
    if (this.jdField_b_of_type_JavaUtilList != null) {
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    anht localanht;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131493457, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int));
      paramViewGroup = new anau(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131299990));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131299992));
      paramViewGroup.jdField_a_of_type_AndroidViewView = localView.findViewById(2131299987);
      paramViewGroup.jdField_b_of_type_AndroidViewView = localView.findViewById(2131299988);
      paramViewGroup.c = localView.findViewById(2131299989);
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131299991));
      localView.setTag(paramViewGroup);
      localanht = (anht)this.jdField_b_of_type_JavaUtilList.get(paramInt);
      if (localanht != paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.getTag(2131313373))
      {
        if (localanht.f != 1) {
          break label483;
        }
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130839346);
        if (AppSetting.jdField_c_of_type_Boolean) {
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626412));
        }
        label205:
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setTag(2131313373, localanht);
      }
      if ((localanht instanceof ankr))
      {
        ankr localankr = (ankr)localanht;
        a(localanht, localankr.a(), paramViewGroup);
        if (localankr.a()) {
          break label517;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844778);
        label275:
        if (this.f != 1) {
          break label538;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        label291:
        if (localanht.f != 1)
        {
          paramView = this.jdField_a_of_type_Amzw.a(localanht);
          if ((!AppSetting.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramView)) || (paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.getVisibility() != 0)) {
            break label603;
          }
          if (localankr.a()) {
            break label550;
          }
          if ((!AppSetting.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(paramView))) {
            break label603;
          }
          paramView = paramView + "," + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131654739);
        }
      }
    }
    label517:
    label538:
    label550:
    label603:
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(paramView);
      if (localanht.f == 1)
      {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidViewView.setVisibility(8);
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      return this.jdField_a_of_type_Amzw.a(paramInt, localView, paramViewGroup, localanht);
      paramViewGroup = (anau)paramView.getTag();
      localView = paramView;
      break;
      label483:
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localanht.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_Float, this.jdField_e_of_type_Int, this.jdField_e_of_type_Int));
      break label205;
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844780);
      break label275;
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break label291;
      if ((AppSetting.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(paramView))) {
        paramView = paramView + "," + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131625238);
      }
    }
  }
  
  public void h()
  {
    m();
    this.jdField_a_of_type_Anav = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 207)
    {
      d(((Integer)paramMessage.obj).intValue());
      notifyDataSetChanged();
      d();
      f();
    }
    do
    {
      do
      {
        return false;
        if (paramMessage.what == 206)
        {
          a((List)paramMessage.obj);
          return false;
        }
      } while ((paramMessage.what != 208) || (!(paramMessage.obj instanceof Integer)));
      paramMessage = (Integer)paramMessage.obj;
      switch (paramMessage.intValue())
      {
      default: 
        return false;
      }
      QLog.e("FavEmosmViewPage", 1, new Object[] { "update ui, over limit flag:", Boolean.valueOf(CameraEmoAllSend.jdField_b_of_type_Boolean), " ret:", paramMessage, " onResumed:", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    } while ((CameraEmoAllSend.jdField_b_of_type_Boolean) || (!this.jdField_d_of_type_Boolean));
    CameraEmoAllSend.jdField_b_of_type_Boolean = true;
    if (paramMessage.intValue() == 7) {}
    for (int i = 1;; i = 2)
    {
      anbp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, i);
      return false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131302832: 
    case 2131299986: 
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Amzw.jdField_b_of_type_Boolean)
          {
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7A", "0X8005C7A", 0, 0, "", "", "", "");
            this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.finish();
            return;
          }
          if (this.f == 1)
          {
            this.f = 0;
            this.jdField_a_of_type_Amzw.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            if ((!this.jdField_a_of_type_Amzw.b()) && (!bajr.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
              this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            }
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
            this.jdField_e_of_type_AndroidWidgetTextView.setText(2131626432);
            this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626433));
            paramView = this.jdField_b_of_type_JavaUtilList.iterator();
            while (paramView.hasNext()) {
              ((anht)paramView.next()).jdField_a_of_type_Boolean = false;
            }
            this.jdField_a_of_type_Amzw.c();
            d();
            if (this.jdField_c_of_type_Boolean)
            {
              m();
              e();
            }
            if (this.jdField_a_of_type_Anav != null) {
              this.jdField_a_of_type_Anav.b(false);
            }
            awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D5", 0, 0, "", "", "", "");
            return;
          }
        } while (this.f != 0);
        this.f = 1;
        this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setSelectMode(true);
        this.jdField_a_of_type_Amzw.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        c(0);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(2131626982);
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626414));
        if ((this.jdField_a_of_type_Amzw.b()) || (bajr.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_b_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.3F);
        this.jdField_a_of_type_Amzw.b();
        this.jdField_a_of_type_Amzw.e();
        if (this.jdField_a_of_type_Anav != null) {
          this.jdField_a_of_type_Anav.b(true);
        }
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D3", 0, 0, "", "", "", "");
        return;
      } while (this.jdField_b_of_type_JavaUtilList == null);
      paramView = this.jdField_b_of_type_JavaUtilList.iterator();
      while (paramView.hasNext())
      {
        anht localanht = (anht)paramView.next();
        if ((localanht instanceof ankr)) {
          localanht.jdField_a_of_type_Boolean = true;
        }
      }
      notifyDataSetChanged();
      d();
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057D6", 0, 0, "", "", "", "");
      return;
    case 2131299985: 
      j();
      return;
    case 2131297980: 
      baoz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, "mvip.n.a.bqsc_edit", 3, "1450000516", "CJCLUBT", this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131654075), "");
    case 2131299995: 
      c();
      this.jdField_a_of_type_Amzw.f();
      return;
    }
    i();
    d();
    bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.getString(2131626420), 0).a();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Amzw.a(paramAdapterView, paramView, paramInt, paramLong)) {}
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            return;
            if (this.f != 0) {
              break;
            }
            if ((this.jdField_a_of_type_Amzw.a()) && (paramInt == 0))
            {
              paramAdapterView = this.jdField_b_of_type_JavaUtilList;
              if ((paramAdapterView != null) && (paramAdapterView.size() > 0) && (((anht)paramAdapterView.get(0)).f == 1))
              {
                l();
                awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A6D6", "0X800A6D6", 0, 0, "", "", "", "");
                return;
              }
            }
            paramAdapterView = getItem(paramInt);
          } while (!(paramAdapterView instanceof ankr));
          paramAdapterView = (ankr)paramAdapterView;
          str = paramAdapterView.a();
          if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onItemClick roamingType = " + str);
          }
          if ((TextUtils.isEmpty(str)) || (!str.equals("needUpload"))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_NEED_UPLOAD");
        return;
        if ((!TextUtils.isEmpty(str)) && (str.equals("failed")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_FAILED");
          }
          this.jdField_a_of_type_Amzw.a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, paramInt, paramAdapterView);
          return;
        }
        if ((TextUtils.isEmpty(str)) || (!str.equals("needDownload"))) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FavEmosmViewPage", 2, "onItemClick ROAMING_TYPE_PANEL");
        }
        paramAdapterView = (anau)paramView.getTag();
        paramView = paramAdapterView.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      } while (!(paramView instanceof URLDrawable));
      paramView = (URLDrawable)paramView;
      if ((paramView.getStatus() == 3) || (paramView.getStatus() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FavEmosmViewPage", 2, "onItemClick restartDownload status = " + paramView.getStatus());
        }
        paramView.restartDownload();
        return;
      }
    } while (paramView.getStatus() != 1);
    AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (anht)getItem(paramInt), xgx.a(paramAdapterView.jdField_a_of_type_ComTencentImageURLImageView));
    return;
    paramAdapterView = (anau)paramView.getTag();
    AIOEmotionFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity, (anht)getItem(paramInt), xgx.a(paramAdapterView.jdField_a_of_type_ComTencentImageURLImageView));
    return;
    paramAdapterView = getItem(paramInt);
    if ((paramAdapterView instanceof anht))
    {
      paramAdapterView = (anht)paramAdapterView;
      if (paramAdapterView.jdField_a_of_type_Boolean) {
        break label483;
      }
    }
    label483:
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.jdField_a_of_type_Boolean = bool;
      a(this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView, paramInt);
      d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anao
 * JD-Core Version:    0.7.0.1
 */