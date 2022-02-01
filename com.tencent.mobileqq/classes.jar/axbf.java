import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class axbf
  extends RecyclerView.Adapter<axbg>
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private long jdField_a_of_type_Long;
  protected algy a;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private axbh jdField_a_of_type_Axbh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList;
  
  public axbf(Context paramContext, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Algy = new algy(paramQQAppInterface, this, false);
  }
  
  private void a(axbg paramaxbg, int paramInt, Drawable paramDrawable)
  {
    boolean bool = true;
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    MsgBackupMsgUserData localMsgBackupMsgUserData;
    if ((localRecentBaseData instanceof MsgBackupMsgUserData))
    {
      localMsgBackupMsgUserData = (MsgBackupMsgUserData)localRecentBaseData;
      QQAppInterface localQQAppInterface = null;
      if (paramDrawable != null) {
        break label224;
      }
      paramDrawable = localQQAppInterface;
      if (this.jdField_a_of_type_Algy != null) {
        paramDrawable = this.jdField_a_of_type_Algy.a(localRecentBaseData);
      }
      if (!a(localRecentBaseData)) {
        break label233;
      }
      localQQAppInterface = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
      int j = ((Integer)algy.a(localQQAppInterface, localRecentBaseData.getRecentUserType(), localRecentBaseData.getRecentUserUin()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      RecentDynamicAvatarView localRecentDynamicAvatarView = paramaxbg.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
      String str = localRecentBaseData.getRecentUserUin();
      if (localQQAppInterface.mAutomator.a() != 1) {
        break label227;
      }
      label146:
      localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
    }
    for (;;)
    {
      paramaxbg.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
      paramaxbg.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentBaseData.mTitleName);
      axbg.a(paramaxbg).setChecked(((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt)).booleanValue());
      if (AppSetting.c) {
        paramaxbg.jdField_a_of_type_AndroidViewView.setContentDescription(localMsgBackupMsgUserData.name);
      }
      return;
      label224:
      break;
      label227:
      bool = false;
      break label146;
      label233:
      paramaxbg.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
    }
  }
  
  private void b(axbg paramaxbg, int paramInt, Drawable paramDrawable)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while ((paramaxbg == null) || (localRecentBaseData == null));
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null)
    {
      int i = localRecentBaseData.getRecentUserType();
      localDrawable = this.jdField_a_of_type_Algy.a(i, localRecentBaseData.getRecentUserUin());
    }
    a(paramaxbg, paramInt, localDrawable);
  }
  
  public axbg a(ViewGroup paramViewGroup, int paramInt)
  {
    return new axbg(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562766, paramViewGroup, false), this.jdField_a_of_type_Axbh);
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, Boolean.valueOf(false));
      i += 1;
    }
  }
  
  protected void a(View paramView)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      paramView = (DynamicAvatarView)paramView;
      if (paramView.a == null) {
        paramView.a = new blfw();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(axbg paramaxbg, int paramInt)
  {
    a(paramaxbg, paramInt, null);
    EventCollector.getInstance().onRecyclerBindViewHolder(paramaxbg, paramInt, getItemId(paramInt));
  }
  
  public void a(axbh paramaxbh)
  {
    this.jdField_a_of_type_Axbh = paramaxbh;
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.getRecentUserType();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
  
  public void b()
  {
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.setValueAt(i, Boolean.valueOf(true));
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public void c()
  {
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    int i = 0;
    while (i < j)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.setValueAt(i, Boolean.valueOf(false));
      i += 1;
    }
    notifyDataSetChanged();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Algy != null) {
      this.jdField_a_of_type_Algy.a();
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
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
            QLog.i("MsgBackup.BackupAndMigrateListAdapter", 1, "onDecodeTaskCompleted error:" + ???.getMessage());
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
        paramBitmap = (axbg)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(paramBitmap);
        int i = paramBitmap.getAdapterPosition();
        Object localObject = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject == null)
        {
          break label438;
          this.jdField_a_of_type_Long = l;
          break;
        }
        int j = ((RecentBaseData)localObject).getRecentUserType();
        j = ((Integer)algy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, ((RecentBaseData)localObject).getRecentUserUin()).first).intValue();
        if (j == -2147483648) {
          break label438;
        }
        localObject = j + ":" + ((RecentBaseData)localObject).getRecentUserUin();
        localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
        if (localObject == null) {
          break label438;
        }
        b(paramBitmap, i, new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), (Bitmap)localObject));
        bool = true;
        break label438;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("MsgBackup.BackupAndMigrateListAdapter", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label438:
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axbf
 * JD-Core Version:    0.7.0.1
 */