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
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgUserData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class auds
  extends RecyclerView.Adapter<audt>
  implements bcwt
{
  private long jdField_a_of_type_Long;
  protected ajfa a;
  private Context jdField_a_of_type_AndroidContentContext;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private audu jdField_a_of_type_Audu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Hashtable<String, Bitmap> jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private List<RecentBaseData> jdField_a_of_type_JavaUtilList;
  
  public auds(Context paramContext, QQAppInterface paramQQAppInterface, RecyclerView paramRecyclerView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = paramRecyclerView;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Ajfa = new ajfa(paramQQAppInterface, this, false);
  }
  
  private void a(audt paramaudt, int paramInt, Drawable paramDrawable)
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
      if (this.jdField_a_of_type_Ajfa != null) {
        paramDrawable = this.jdField_a_of_type_Ajfa.a(localRecentBaseData);
      }
      if (!a(localRecentBaseData)) {
        break label233;
      }
      localQQAppInterface = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app;
      int j = ((Integer)ajfa.a(localQQAppInterface, localRecentBaseData.a(), localRecentBaseData.a()).first).intValue();
      int i = j;
      if (j == 103) {
        i = 1;
      }
      RecentDynamicAvatarView localRecentDynamicAvatarView = paramaudt.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView;
      String str = localRecentBaseData.a();
      if (localQQAppInterface.a.a() != 1) {
        break label227;
      }
      label146:
      localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
    }
    for (;;)
    {
      paramaudt.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
      paramaudt.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localRecentBaseData.mTitleName);
      audt.a(paramaudt).setChecked(((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(paramInt)).booleanValue());
      if (AppSetting.c) {
        paramaudt.jdField_a_of_type_AndroidViewView.setContentDescription(localMsgBackupMsgUserData.name);
      }
      return;
      label224:
      break;
      label227:
      bool = false;
      break label146;
      label233:
      paramaudt.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable(paramDrawable);
    }
  }
  
  private void b(audt paramaudt, int paramInt, Drawable paramDrawable)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    RecentBaseData localRecentBaseData;
    do
    {
      return;
      localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while ((paramaudt == null) || (localRecentBaseData == null));
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null)
    {
      int i = localRecentBaseData.a();
      localDrawable = this.jdField_a_of_type_Ajfa.a(i, localRecentBaseData.a());
    }
    a(paramaudt, paramInt, localDrawable);
  }
  
  public audt a(ViewGroup paramViewGroup, int paramInt)
  {
    return new audt(this, this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562526, paramViewGroup, false), this.jdField_a_of_type_Audu);
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
        paramView.a = new bhxo();
      }
      paramView.a.a(true);
    }
  }
  
  public void a(audt paramaudt, int paramInt)
  {
    a(paramaudt, paramInt, null);
  }
  
  public void a(audu paramaudu)
  {
    this.jdField_a_of_type_Audu = paramaudu;
  }
  
  public void a(List<RecentBaseData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  protected boolean a(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.a();
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
    if (this.jdField_a_of_type_Ajfa != null) {
      this.jdField_a_of_type_Ajfa.a();
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
        paramBitmap = (audt)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildViewHolder(paramBitmap);
        int i = paramBitmap.getAdapterPosition();
        Object localObject = (RecentBaseData)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject == null)
        {
          break label438;
          this.jdField_a_of_type_Long = l;
          break;
        }
        int j = ((RecentBaseData)localObject).a();
        j = ((Integer)ajfa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, j, ((RecentBaseData)localObject).a()).first).intValue();
        if (j == -2147483648) {
          break label438;
        }
        localObject = j + ":" + ((RecentBaseData)localObject).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auds
 * JD-Core Version:    0.7.0.1
 */