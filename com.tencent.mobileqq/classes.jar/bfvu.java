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
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.widget.CircleFileStateView;
import cooperation.troop.TroopFileProxyActivity;
import java.util.Map;

public class bfvu
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
  protected aunx a;
  protected bfrs a;
  protected bfsf a;
  private bfvz jdField_a_of_type_Bfvz;
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
  
  public bfvu(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379543);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379548));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379549));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379546));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379547));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379544));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131366617));
    this.jdField_a_of_type_Bfsf = new bfsf(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    a();
    this.jdField_a_of_type_JavaLangString = "";
    b();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong *= 1000L;
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    if (paramLong <= l) {
      return paramContext.getString(2131696656);
    }
    paramLong = (paramLong - l) / 86400000L;
    return paramLong + 1L + paramContext.getString(2131696629);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(anzj.a(2131714122));
    }
    long l3;
    long l1;
    for (;;)
    {
      long l4 = this.jdField_a_of_type_Bfrs.jdField_d_of_type_Long;
      long l2 = this.jdField_a_of_type_Bfrs.jdField_a_of_type_Long;
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(anzj.a(2131714102));
      } else if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(anzj.a(2131714103));
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
  
  protected bfrs a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof bfrs))) {
      return null;
    }
    return (bfrs)paramView;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bfvv(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new bfvw(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bfvx(this);
    this.jdField_a_of_type_Aunx = new bfvy(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bfrs == null) {
      return;
    }
    String str1 = "";
    String str2 = "";
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(this.jdField_a_of_type_Bfrs);
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Bfrs);
    paramContext.getResources();
    this.c = this.jdField_a_of_type_Bfrs.jdField_d_of_type_Boolean;
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Object localObject1 = this.jdField_a_of_type_Bfrs.jdField_c_of_type_JavaLangString;
    int i;
    if (!this.c)
    {
      if ((!paramBoolean) && (this.jdField_a_of_type_Bfrs != null) && (this.jdField_a_of_type_Bfrs.i == null)) {
        paramQQAppInterface.a(this.jdField_a_of_type_Bfrs.jdField_a_of_type_JavaUtilUUID, 128);
      }
      if (bhmi.b(this.jdField_a_of_type_Bfrs.i))
      {
        i = aunj.a(this.jdField_a_of_type_Bfrs.jdField_c_of_type_JavaLangString);
        aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_a_of_type_Bfrs.i, i);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(anzj.a(2131714129));
        label176:
        if (this.c) {
          break label560;
        }
        str2 = this.jdField_a_of_type_Bfrs.a();
        paramQQAppInterface = this.jdField_a_of_type_Bfrs.c();
        str1 = this.jdField_a_of_type_Bfrs.l;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        if (this.jdField_d_of_type_Boolean) {
          paramQQAppInterface = "";
        }
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bfrs.jdField_c_of_type_Int != 0)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Bfrs.jdField_a_of_type_Int != 102) {
            localObject1 = a(paramContext, this.jdField_a_of_type_Bfrs.jdField_c_of_type_Int);
          }
        }
        paramBoolean = bfrt.a(this.jdField_a_of_type_Bfrs.e);
        i = 1;
        if (!paramBoolean) {
          break label748;
        }
        i = 0;
        label318:
        if ((this.jdField_a_of_type_Bfrs.e != 0) && (this.jdField_a_of_type_Bfrs.e != 1) && (this.jdField_a_of_type_Bfrs.e != 2) && (this.jdField_a_of_type_Bfrs.e != 8) && (this.jdField_a_of_type_Bfrs.e != 9)) {
          break label761;
        }
        paramBoolean = true;
        label377:
        if ((this.jdField_a_of_type_Bfrs.e != 11) && (this.jdField_a_of_type_Bfrs.e != 6)) {
          break label775;
        }
        if (!auog.b(this.jdField_a_of_type_Bfrs.jdField_h_of_type_JavaLangString)) {
          break label767;
        }
        c(true);
        label419:
        a(paramBoolean, this.jdField_a_of_type_AndroidUtilSparseIntArray.get(this.jdField_a_of_type_Bfrs.e, -1));
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
        if (this.jdField_a_of_type_Bfrs.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
        }
      }
      for (;;)
      {
        auoo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetTextView, str1, paramContext, str2, (String)localObject1, this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_Aunx);
        return;
        i = aunj.b(this.jdField_a_of_type_Bfrs.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130844319);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(anzj.a(2131714145));
        break label176;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.jdField_a_of_type_Bfrs.jdField_a_of_type_JavaUtilMap.size() > 0) {}
        for (paramQQAppInterface = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696694), new Object[] { Integer.valueOf(this.jdField_a_of_type_Bfrs.jdField_a_of_type_JavaUtilMap.size()) });; paramQQAppInterface = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696657), new Object[] { Integer.valueOf(this.jdField_a_of_type_Bfrs.jdField_h_of_type_Int) }))
        {
          localObject1 = this.jdField_a_of_type_Bfrs.m;
          this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692144) + paramQQAppInterface);
          paramQQAppInterface = "";
          break;
          if (this.jdField_a_of_type_Bfrs.jdField_h_of_type_Int < 0) {
            this.jdField_a_of_type_Bfrs.jdField_h_of_type_Int = 0;
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
    if (this.jdField_a_of_type_Bfrs == null) {}
    while ((this.jdField_a_of_type_Bfrs.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Bfrs == null) || (this.jdField_a_of_type_Bfrs.i != null)) {
      return;
    }
    TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(this.jdField_a_of_type_Bfrs.jdField_a_of_type_JavaUtilUUID, 128);
  }
  
  protected void a(View paramView)
  {
    bfrs localbfrs = a(paramView.findViewById(2131379544));
    if (localbfrs == null) {}
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
        } while (localbfrs.jdField_d_of_type_Boolean);
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (this.jdField_a_of_type_Bfvz == null);
      this.jdField_a_of_type_Bfvz.a(false, localbfrs);
      return;
    } while (this.jdField_a_of_type_Bfvz == null);
    this.jdField_a_of_type_Bfvz.a(true, localbfrs);
    return;
    if (!localbfrs.jdField_d_of_type_Boolean)
    {
      switch (localbfrs.e)
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
        bftf localbftf = this.jdField_a_of_type_Bfsf.a(localbfrs);
        int i = this.jdField_a_of_type_Bfsf.a(localbfrs);
        paramView = auoo.a(paramView.findViewById(2131379548), localbfrs.jdField_c_of_type_JavaLangString);
        auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Long, localbftf, String.valueOf(localbfrs.jdField_b_of_type_Long), localbfrs.jdField_c_of_type_Int, i, this.jdField_a_of_type_Int, paramView, false, false);
        return;
      case 13: 
        this.jdField_a_of_type_Bfsf.f(localbfrs);
        return;
      }
      this.jdField_a_of_type_Bfsf.a(localbfrs, this.jdField_a_of_type_AndroidContentContext.getString(2131697091), this.jdField_a_of_type_AndroidContentContext.getString(2131697092));
      return;
    }
    paramView = new Intent();
    paramView.putExtra(beai.e, this.jdField_a_of_type_Long);
    paramView.putExtra("folderPath", localbfrs.jdField_b_of_type_JavaLangString);
    paramView.putExtra("folderName", localbfrs.jdField_c_of_type_JavaLangString);
    paramView.putExtra("param_from", 2000);
    TroopFileProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (paramView.getId() == 2131379544) {}
      while ((paramView != null) && ((paramView instanceof CircleFileStateView)))
      {
        ((CircleFileStateView)paramView).setState(paramInt);
        return;
        paramView = paramView.findViewById(2131379544);
      }
    }
  }
  
  public void a(bfvz parambfvz)
  {
    this.jdField_a_of_type_Bfvz = parambfvz;
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((this.jdField_a_of_type_Bfrs != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bfrs.a(paramQQAppInterface, paramLong)))) {}
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
    if (this.jdField_a_of_type_Bfrs == null) {}
    while (this.jdField_a_of_type_Bfrs.jdField_d_of_type_Boolean) {
      return;
    }
    if (bhmi.b(this.jdField_a_of_type_Bfrs.i))
    {
      i = aunj.a(this.jdField_a_of_type_Bfrs.jdField_c_of_type_JavaLangString);
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_a_of_type_Bfrs.i, i);
      return;
    }
    int i = aunj.b(this.jdField_a_of_type_Bfrs.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
  }
  
  protected void b(View paramView)
  {
    bfrs localbfrs = a(paramView);
    if (localbfrs == null) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    switch (localbfrs.e)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
    case 1: 
      localTroopFileTransferManager.a(localbfrs.jdField_a_of_type_JavaUtilUUID);
      a(paramView, 3);
      return;
    case 2: 
      this.jdField_a_of_type_Bfsf.a(localbfrs.jdField_a_of_type_JavaUtilUUID);
      return;
    case 3: 
      this.jdField_a_of_type_Bfsf.c(localbfrs);
      return;
    case 8: 
      localTroopFileTransferManager.d(localbfrs.jdField_a_of_type_JavaUtilUUID);
      a(paramView, 2);
      return;
    case 9: 
      this.jdField_a_of_type_Bfsf.b(localbfrs.jdField_a_of_type_JavaUtilUUID);
      return;
    case 10: 
      this.jdField_a_of_type_Bfsf.d(localbfrs);
      a(paramView, 2);
      return;
    case 6: 
    case 11: 
      paramView = this.jdField_a_of_type_Bfsf.a(localbfrs);
      int i = this.jdField_a_of_type_Bfsf.a(localbfrs);
      auoo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Long, paramView, String.valueOf(localbfrs.jdField_b_of_type_Long), localbfrs.jdField_c_of_type_Int, i, this.jdField_a_of_type_Int, null, false, false);
      return;
    case 7: 
      this.jdField_a_of_type_Bfsf.a(localbfrs.jdField_b_of_type_JavaLangString, localbfrs.jdField_c_of_type_JavaLangString, localbfrs.jdField_a_of_type_Long, localbfrs.jdField_a_of_type_Int);
      a(paramView, 2);
      return;
    case 13: 
      this.jdField_a_of_type_Bfsf.f(localbfrs);
      a(paramView, 1);
      return;
    }
    this.jdField_a_of_type_Bfsf.a(localbfrs, this.jdField_a_of_type_AndroidContentContext.getString(2131697091), this.jdField_a_of_type_AndroidContentContext.getString(2131697092));
    a(paramView, 2);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected void c(View paramView)
  {
    paramView = a((TextView)paramView.findViewById(2131379546));
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
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131692145);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfvu
 * JD-Core Version:    0.7.0.1
 */