import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentCallItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ayfq
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements bdbc
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  protected ajjp a;
  private final Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ayfr jdField_a_of_type_Ayfr;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<RecentBaseData> jdField_a_of_type_JavaUtilArrayList;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_a_of_type_Boolean = true;
  
  public ayfq(Context paramContext, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Ajjp = new ajjp(paramQQAppInterface, this, false);
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt == 1) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  @Nullable
  private RecentBaseData a(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_Boolean)) {
      return (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
    }
    return (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  private void a(ayft paramayft, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    boolean bool = true;
    RecentDynamicAvatarView localRecentDynamicAvatarView = null;
    if (paramDrawable == null)
    {
      paramDrawable = localRecentDynamicAvatarView;
      if (this.jdField_a_of_type_Ajjp != null) {
        paramDrawable = this.jdField_a_of_type_Ajjp.a(paramRecentBaseData);
      }
      if (!a(paramRecentBaseData)) {
        break label182;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ScreenShotAdapter", 2, "bindview user:" + paramRecentBaseData.a());
      }
      int j = ((Integer)ajjp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecentBaseData.a(), paramRecentBaseData.a()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      localRecentDynamicAvatarView = paramayft.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = paramRecentBaseData.a();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a() != 1) {
        break label176;
      }
      label143:
      localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
    }
    for (;;)
    {
      paramayft.jdField_a_of_type_AndroidWidgetTextView.setText(paramRecentBaseData.b());
      return;
      break;
      label176:
      bool = false;
      break label143;
      label182:
      paramayft.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
    }
  }
  
  private void b(ayft paramayft, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramayft == null) || (paramRecentBaseData == null)) {
      return;
    }
    Drawable localDrawable = paramDrawable;
    int i;
    if (paramDrawable == null)
    {
      i = paramRecentBaseData.a();
      if ((!(paramRecentBaseData instanceof RecentCallItem)) || (!((RecentCallItem)paramRecentBaseData).b())) {
        break label68;
      }
      i = 3002;
    }
    label68:
    for (;;)
    {
      localDrawable = this.jdField_a_of_type_Ajjp.a(i, paramRecentBaseData.a());
      a(paramayft, paramRecentBaseData, localDrawable);
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajjp != null) {
      this.jdField_a_of_type_Ajjp.a();
    }
  }
  
  public void a(ayfr paramayfr)
  {
    this.jdField_a_of_type_Ayfr = paramayfr;
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.a();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean)) {
      return 0;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof ayft))
    {
      RecentBaseData localRecentBaseData = a(paramInt);
      a((ayft)paramViewHolder, localRecentBaseData, null);
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Boolean)) {
      return new ayfs(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562580, paramViewGroup, false));
    }
    return new ayft(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561253, paramViewGroup, false), this.jdField_a_of_type_Ayfr);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if (TextUtils.isEmpty(???)) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {}
        try
        {
          this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + ???, paramBitmap);
          l = System.currentTimeMillis();
          if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L))
          {
            paramInt2 = 1;
            if ((paramInt1 > 0) && (paramInt2 == 0)) {
              continue;
            }
            synchronized (this.jdField_a_of_type_JavaUtilHashtable)
            {
              if (this.jdField_a_of_type_JavaUtilHashtable.size() == 0) {
                return;
              }
            }
          }
        }
        catch (OutOfMemoryError ???)
        {
          for (;;)
          {
            System.gc();
            ???.printStackTrace();
            QLog.i("ScreenShotAdapter", 1, "onDecodeTaskCompleted error:" + ???.getMessage());
            continue;
            paramInt2 = 0;
          }
        }
      }
    }
    boolean bool;
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Long = 0L;
      paramInt2 = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildCount();
      paramInt1 = 0;
      bool = false;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAt(paramInt1);
        paramBitmap = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(paramBitmap);
        if (!(paramBitmap instanceof ayft))
        {
          break label436;
          this.jdField_a_of_type_Long = l;
          break;
        }
        paramBitmap = (ayft)paramBitmap;
        RecentBaseData localRecentBaseData = a(paramBitmap.getAdapterPosition());
        if (localRecentBaseData == null) {
          break label436;
        }
        int i = localRecentBaseData.a();
        i = ((Integer)ajjp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, localRecentBaseData.a()).first).intValue();
        if (i == -2147483648) {
          break label436;
        }
        Object localObject = i + ":" + localRecentBaseData.a();
        localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
        if (localObject == null) {
          break label436;
        }
        b(paramBitmap, localRecentBaseData, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject));
        bool = true;
        break label436;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("ScreenShotAdapter", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label436:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfq
 * JD-Core Version:    0.7.0.1
 */