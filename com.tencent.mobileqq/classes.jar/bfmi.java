import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.CircleFileStateView;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Map;

public class bfmi
{
  protected int a;
  protected long a;
  protected Context a;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  protected View a;
  protected CheckBox a;
  protected ImageView a;
  protected TextView a;
  protected aueo a;
  protected bfif a;
  protected bfis a;
  private bfmn jdField_a_of_type_Bfmn;
  protected QQAppInterface a;
  protected AsyncImageView a;
  protected EllipsizingTextView a;
  protected CircleFileStateView a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  protected View.OnClickListener b;
  protected View b;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public bfmi(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379629);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379634));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379635));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379632));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379633));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379630));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131366755));
    this.jdField_a_of_type_Bfis = new bfis(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    a();
    this.jdField_a_of_type_JavaLangString = "";
    b();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong *= 1000L;
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    if (paramLong <= l) {
      return paramContext.getString(2131697064);
    }
    paramLong = (paramLong - l) / 86400000L;
    return paramLong + 1L + paramContext.getString(2131697037);
  }
  
  private final void a(boolean paramBoolean, int paramInt)
  {
    CircleFileStateView localCircleFileStateView = this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localCircleFileStateView.setVisibility(i);
      if (paramInt != -1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(paramInt);
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(anvx.a(2131714701));
    }
    long l3;
    long l1;
    for (;;)
    {
      long l4 = this.jdField_a_of_type_Bfif.jdField_d_of_type_Long;
      long l2 = this.jdField_a_of_type_Bfif.jdField_a_of_type_Long;
      l3 = l2;
      l1 = l4;
      if (l4 > l2)
      {
        l1 = l2;
        l3 = l2;
      }
      while (l3 > 2147483647L)
      {
        l3 >>= 1;
        l1 >>= 1;
      }
      if (paramInt == 3) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(anvx.a(2131714681));
      } else if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(anvx.a(2131714682));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription("");
      }
    }
    paramInt = (int)(l1 * 100.0D / l3);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress(paramInt);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(1, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(3, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(6, -1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(8, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(9, 2);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(10, 2);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(11, -1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(7, -1);
  }
  
  protected bfif a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof bfif))) {
      return null;
    }
    return (bfif)paramView;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bfmj(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new bfmk(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bfml(this);
    this.jdField_a_of_type_Aueo = new bfmm(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bfif == null) {
      return;
    }
    String str1 = "";
    String str2 = "";
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(this.jdField_a_of_type_Bfif);
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Bfif);
    paramContext.getResources();
    this.c = this.jdField_a_of_type_Bfif.jdField_d_of_type_Boolean;
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Object localObject1 = this.jdField_a_of_type_Bfif.jdField_c_of_type_JavaLangString;
    int i;
    if (!this.c)
    {
      if ((!paramBoolean) && (this.jdField_a_of_type_Bfif != null) && (this.jdField_a_of_type_Bfif.j == null)) {
        paramQQAppInterface.a(this.jdField_a_of_type_Bfif.jdField_a_of_type_JavaUtilUUID, 128);
      }
      if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Bfif.j))
      {
        i = auea.a(this.jdField_a_of_type_Bfif.jdField_c_of_type_JavaLangString);
        auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_a_of_type_Bfif.j, i);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(anvx.a(2131714708));
        label176:
        if (this.c) {
          break label560;
        }
        str2 = this.jdField_a_of_type_Bfif.a();
        paramQQAppInterface = this.jdField_a_of_type_Bfif.c();
        str1 = this.jdField_a_of_type_Bfif.m;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        if (this.jdField_d_of_type_Boolean) {
          paramQQAppInterface = "";
        }
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bfif.jdField_c_of_type_Int != 0)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Bfif.jdField_a_of_type_Int != 102) {
            localObject1 = a(paramContext, this.jdField_a_of_type_Bfif.jdField_c_of_type_Int);
          }
        }
        paramBoolean = bfig.a(this.jdField_a_of_type_Bfif.e);
        i = 1;
        if (!paramBoolean) {
          break label748;
        }
        i = 0;
        label318:
        if ((this.jdField_a_of_type_Bfif.e != 0) && (this.jdField_a_of_type_Bfif.e != 1) && (this.jdField_a_of_type_Bfif.e != 2) && (this.jdField_a_of_type_Bfif.e != 8) && (this.jdField_a_of_type_Bfif.e != 9)) {
          break label761;
        }
        paramBoolean = true;
        label377:
        if ((this.jdField_a_of_type_Bfif.e != 11) && (this.jdField_a_of_type_Bfif.e != 6)) {
          break label775;
        }
        if (!FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_Bfif.i)) {
          break label767;
        }
        c(true);
        label419:
        a(paramBoolean, this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Bfif.e, -1));
        if (i != 0) {
          break label817;
        }
      }
    }
    label560:
    label817:
    for (paramContext = "";; paramContext = paramQQAppInterface)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        if (this.jdField_a_of_type_Bfif.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
        }
      }
      for (;;)
      {
        aufd.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetTextView, str1, paramContext, str2, (String)localObject1, this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_Aueo);
        return;
        i = auea.b(this.jdField_a_of_type_Bfif.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844271);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(anvx.a(2131714724));
        break label176;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.jdField_a_of_type_Bfif.jdField_a_of_type_JavaUtilMap.size() > 0) {}
        for (paramQQAppInterface = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697103), new Object[] { Integer.valueOf(this.jdField_a_of_type_Bfif.jdField_a_of_type_JavaUtilMap.size()) });; paramQQAppInterface = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697066), new Object[] { Integer.valueOf(this.jdField_a_of_type_Bfif.h) }))
        {
          localObject1 = this.jdField_a_of_type_Bfif.n;
          this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692282) + paramQQAppInterface);
          paramQQAppInterface = "";
          break;
          if (this.jdField_a_of_type_Bfif.h < 0) {
            this.jdField_a_of_type_Bfif.h = 0;
          }
        }
        label748:
        if (!this.jdField_d_of_type_Boolean) {
          break label318;
        }
        i = 0;
        break label318;
        label761:
        paramBoolean = false;
        break label377;
        label767:
        c(false);
        break label419;
        c(false);
        break label419;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_b_of_type_Boolean);
        continue;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
  }
  
  public void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Bfif == null) {}
    while ((this.jdField_a_of_type_Bfif.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Bfif == null) || (this.jdField_a_of_type_Bfif.j != null)) {
      return;
    }
    TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(this.jdField_a_of_type_Bfif.jdField_a_of_type_JavaUtilUUID, 128);
  }
  
  protected void a(View paramView)
  {
    bfif localbfif = a(paramView.findViewById(2131379630));
    if (localbfif == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
        } while (localbfif.jdField_d_of_type_Boolean);
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (this.jdField_a_of_type_Bfmn == null);
      this.jdField_a_of_type_Bfmn.a(false, localbfif);
      return;
    } while (this.jdField_a_of_type_Bfmn == null);
    this.jdField_a_of_type_Bfmn.a(true, localbfif);
    return;
    if (!localbfif.jdField_d_of_type_Boolean)
    {
      switch (localbfif.e)
      {
      case 4: 
      case 5: 
      default: 
        return;
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
        bfjs localbfjs = this.jdField_a_of_type_Bfis.a(localbfif);
        int i = this.jdField_a_of_type_Bfis.a(localbfif);
        paramView = aufd.a(paramView.findViewById(2131379634), localbfif.jdField_c_of_type_JavaLangString);
        aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Long, localbfjs, String.valueOf(localbfif.jdField_b_of_type_Long), localbfif.jdField_c_of_type_Int, i, this.jdField_a_of_type_Int, paramView, false, false);
        return;
      case 13: 
        this.jdField_a_of_type_Bfis.f(localbfif);
        return;
      }
      this.jdField_a_of_type_Bfis.a(localbfif, this.jdField_a_of_type_AndroidContentContext.getString(2131697510), this.jdField_a_of_type_AndroidContentContext.getString(2131697511));
      return;
    }
    paramView = new Intent();
    paramView.putExtra(beay.e, this.jdField_a_of_type_Long);
    paramView.putExtra("folderPath", localbfif.jdField_b_of_type_JavaLangString);
    paramView.putExtra("folderName", localbfif.jdField_c_of_type_JavaLangString);
    paramView.putExtra("param_from", 2000);
    TroopFileProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (paramView.getId() == 2131379630) {}
      while ((paramView != null) && ((paramView instanceof CircleFileStateView)))
      {
        ((CircleFileStateView)paramView).setState(paramInt);
        return;
        paramView = paramView.findViewById(2131379630);
      }
    }
  }
  
  public void a(bfmn parambfmn)
  {
    this.jdField_a_of_type_Bfmn = parambfmn;
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((this.jdField_a_of_type_Bfif != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bfif.a(paramQQAppInterface, paramLong)))) {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected boolean a(View paramView)
  {
    return false;
  }
  
  public void b(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Bfif == null) {}
    while (this.jdField_a_of_type_Bfif.jdField_d_of_type_Boolean) {
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Bfif.j))
    {
      i = auea.a(this.jdField_a_of_type_Bfif.jdField_c_of_type_JavaLangString);
      auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_a_of_type_Bfif.j, i);
      return;
    }
    int i = auea.b(this.jdField_a_of_type_Bfif.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
  }
  
  protected void b(View paramView)
  {
    bfif localbfif = a(paramView);
    if (localbfif == null) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    switch (localbfif.e)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
    case 1: 
      localTroopFileTransferManager.a(localbfif.jdField_a_of_type_JavaUtilUUID);
      a(paramView, 3);
      return;
    case 2: 
      this.jdField_a_of_type_Bfis.a(localbfif.jdField_a_of_type_JavaUtilUUID);
      return;
    case 3: 
      this.jdField_a_of_type_Bfis.c(localbfif);
      return;
    case 8: 
      localTroopFileTransferManager.d(localbfif.jdField_a_of_type_JavaUtilUUID);
      a(paramView, 2);
      return;
    case 9: 
      this.jdField_a_of_type_Bfis.b(localbfif.jdField_a_of_type_JavaUtilUUID);
      return;
    case 10: 
      this.jdField_a_of_type_Bfis.d(localbfif);
      a(paramView, 2);
      return;
    case 6: 
    case 11: 
      paramView = this.jdField_a_of_type_Bfis.a(localbfif);
      int i = this.jdField_a_of_type_Bfis.a(localbfif);
      aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Long, paramView, String.valueOf(localbfif.jdField_b_of_type_Long), localbfif.jdField_c_of_type_Int, i, this.jdField_a_of_type_Int, null, false, false);
      return;
    case 7: 
      this.jdField_a_of_type_Bfis.a(localbfif.jdField_b_of_type_JavaLangString, localbfif.jdField_c_of_type_JavaLangString, localbfif.jdField_a_of_type_Long, localbfif.jdField_a_of_type_Int);
      a(paramView, 2);
      return;
    case 13: 
      this.jdField_a_of_type_Bfis.f(localbfif);
      a(paramView, 1);
      return;
    }
    this.jdField_a_of_type_Bfis.a(localbfif, this.jdField_a_of_type_AndroidContentContext.getString(2131697510), this.jdField_a_of_type_AndroidContentContext.getString(2131697511));
    a(paramView, 2);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected void c(View paramView)
  {
    paramView = a((TextView)paramView.findViewById(2131379632));
    if (paramView == null) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    localIntent.putExtra("filter_member_name", paramView.c());
    localIntent.putExtra("filter_uin", paramView.jdField_b_of_type_Long);
    localIntent.putExtra("folderPath", "/");
    localIntent.putExtra("param_from", 4000);
    TroopFileProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131692283);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmi
 * JD-Core Version:    0.7.0.1
 */