import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
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

public class bbrf
{
  protected int a;
  protected long a;
  protected Context a;
  protected View.OnClickListener a;
  protected View.OnLongClickListener a;
  protected View a;
  protected CheckBox a;
  protected ImageView a;
  protected TextView a;
  protected arnx a;
  protected bbnr a;
  protected bboe a;
  private bbrk jdField_a_of_type_Bbrk;
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
  
  public bbrf(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(paramInt1, null);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378470);
    this.jdField_a_of_type_AndroidViewView.setTag(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378475));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378476));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378473));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378474));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView = ((CircleFileStateView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378471));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)this.jdField_b_of_type_AndroidViewView.findViewById(2131366313));
    this.jdField_a_of_type_Bboe = new bboe(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    a();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    paramLong *= 1000L;
    long l = NetConnInfoCenter.getServerTime() * 1000L;
    if (paramLong <= l) {
      return paramContext.getString(2131697763);
    }
    paramLong = (paramLong - l) / 86400000L;
    return paramLong + 1L + paramContext.getString(2131697736);
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      paramString.setVisibility(i);
      if (paramInt != -1) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setState(paramInt);
    if (paramInt == 1) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(alpo.a(2131715720));
    }
    long l3;
    long l1;
    for (;;)
    {
      long l4 = this.jdField_a_of_type_Bbnr.jdField_d_of_type_Long;
      long l2 = this.jdField_a_of_type_Bbnr.jdField_a_of_type_Long;
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(alpo.a(2131715700));
      } else if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription(alpo.a(2131715701));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setContentDescription("");
      }
    }
    paramInt = (int)(l1 * 100.0D / l3);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setProgress(paramInt);
  }
  
  protected bbnr a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    paramView = paramView.getTag();
    if ((paramView == null) || (!(paramView instanceof bbnr))) {
      return null;
    }
    return (bbnr)paramView;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bbrg(this);
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new bbrh(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new bbri(this);
    this.jdField_a_of_type_Arnx = new bbrj(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidViewView.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a(long paramLong, Context paramContext, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bbnr == null) {
      return;
    }
    String str1 = "";
    String str2 = "";
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setTag(this.jdField_a_of_type_Bbnr);
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(this.jdField_a_of_type_Bbnr);
    paramContext.getResources();
    this.c = this.jdField_a_of_type_Bbnr.jdField_d_of_type_Boolean;
    paramQQAppInterface = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Object localObject1 = this.jdField_a_of_type_Bbnr.jdField_c_of_type_JavaLangString;
    int i;
    label175:
    boolean bool;
    if (!this.c)
    {
      if ((!paramBoolean) && (this.jdField_a_of_type_Bbnr != null) && (this.jdField_a_of_type_Bbnr.i == null)) {
        paramQQAppInterface.a(this.jdField_a_of_type_Bbnr.jdField_a_of_type_JavaUtilUUID, 128);
      }
      if (bdcs.b(this.jdField_a_of_type_Bbnr.i))
      {
        i = arni.a(this.jdField_a_of_type_Bbnr.jdField_c_of_type_JavaLangString);
        arni.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_a_of_type_Bbnr.i, i);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(alpo.a(2131715727));
        if (this.c) {
          break label621;
        }
        str2 = this.jdField_a_of_type_Bbnr.a();
        paramQQAppInterface = this.jdField_a_of_type_Bbnr.c();
        str1 = this.jdField_a_of_type_Bbnr.l;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        if (this.jdField_d_of_type_Boolean) {
          paramQQAppInterface = "";
        }
        Object localObject2 = null;
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Bbnr.jdField_c_of_type_Int != 0)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Bbnr.jdField_a_of_type_Int != 102) {
            localObject1 = a(paramContext, this.jdField_a_of_type_Bbnr.jdField_c_of_type_Int);
          }
        }
        bool = bbns.a(this.jdField_a_of_type_Bbnr.e);
        paramBoolean = true;
        if (!bool) {
          break label809;
        }
        paramBoolean = false;
        label317:
        if ((this.jdField_a_of_type_Bbnr.e != 0) && (this.jdField_a_of_type_Bbnr.e != 1) && (this.jdField_a_of_type_Bbnr.e != 2) && (this.jdField_a_of_type_Bbnr.e != 8) && (this.jdField_a_of_type_Bbnr.e != 9)) {
          break label822;
        }
        bool = true;
        label376:
        if ((this.jdField_a_of_type_Bbnr.e != 11) && (this.jdField_a_of_type_Bbnr.e != 6)) {
          break label836;
        }
        if (!arof.b(this.jdField_a_of_type_Bbnr.jdField_h_of_type_JavaLangString)) {
          break label828;
        }
        c(true);
        label418:
        switch (this.jdField_a_of_type_Bbnr.e)
        {
        case 4: 
        case 5: 
        default: 
          a(bool, paramBoolean, (String)localObject1, 2130843299);
          label501:
          if (paramBoolean) {
            break;
          }
        }
      }
    }
    for (paramContext = "";; paramContext = paramQQAppInterface)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCircleFileStateView.setVisibility(8);
        if (this.jdField_a_of_type_Bbnr.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(4);
        }
      }
      for (;;)
      {
        aroo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetTextView, str1, paramContext, str2, (String)localObject1, this.jdField_a_of_type_JavaLangString, true, this.jdField_a_of_type_Arnx);
        return;
        i = arni.b(this.jdField_a_of_type_Bbnr.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(2130843842);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setContentDescription(alpo.a(2131715743));
        break label175;
        label621:
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.jdField_a_of_type_Bbnr.jdField_a_of_type_JavaUtilMap.size() > 0) {}
        for (paramQQAppInterface = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697801), new Object[] { Integer.valueOf(this.jdField_a_of_type_Bbnr.jdField_a_of_type_JavaUtilMap.size()) });; paramQQAppInterface = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697764), new Object[] { Integer.valueOf(this.jdField_a_of_type_Bbnr.jdField_h_of_type_Int) }))
        {
          localObject1 = this.jdField_a_of_type_Bbnr.m;
          this.jdField_a_of_type_AndroidWidgetTextView.setText((String)localObject1 + this.jdField_a_of_type_AndroidContentContext.getString(2131692552) + paramQQAppInterface);
          paramQQAppInterface = "";
          break;
          if (this.jdField_a_of_type_Bbnr.jdField_h_of_type_Int < 0) {
            this.jdField_a_of_type_Bbnr.jdField_h_of_type_Int = 0;
          }
        }
        label809:
        if (!this.jdField_d_of_type_Boolean) {
          break label317;
        }
        paramBoolean = false;
        break label317;
        label822:
        bool = false;
        break label376;
        label828:
        c(false);
        break label418;
        label836:
        c(false);
        break label418;
        a(bool, paramBoolean, null, 1);
        break label501;
        a(bool, paramBoolean, null, 1);
        break label501;
        a(bool, paramBoolean, null, 3);
        break label501;
        a(bool, paramBoolean, null, 3);
        break label501;
        a(bool, paramBoolean, (String)localObject1, -1);
        break label501;
        a(bool, paramBoolean, (String)localObject1, 1);
        break label501;
        a(bool, paramBoolean, (String)localObject1, 2);
        break label501;
        a(bool, paramBoolean, (String)localObject1, 2);
        break label501;
        a(bool, paramBoolean, (String)localObject1, -1);
        break label501;
        a(bool, paramBoolean, (String)localObject1, -1);
        break label501;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_b_of_type_Boolean);
        continue;
        this.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      }
    }
  }
  
  public void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Bbnr == null) {}
    while ((this.jdField_a_of_type_Bbnr.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_Bbnr == null) || (this.jdField_a_of_type_Bbnr.i != null)) {
      return;
    }
    TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(this.jdField_a_of_type_Bbnr.jdField_a_of_type_JavaUtilUUID, 128);
  }
  
  protected void a(View paramView)
  {
    bbnr localbbnr = a(paramView.findViewById(2131378471));
    if (localbbnr == null) {}
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
        } while (localbbnr.jdField_d_of_type_Boolean);
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (this.jdField_a_of_type_Bbrk == null);
      this.jdField_a_of_type_Bbrk.a(false, localbbnr);
      return;
    } while (this.jdField_a_of_type_Bbrk == null);
    this.jdField_a_of_type_Bbrk.a(true, localbbnr);
    return;
    if (!localbbnr.jdField_d_of_type_Boolean)
    {
      switch (localbbnr.e)
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
        bbpe localbbpe = this.jdField_a_of_type_Bboe.a(localbbnr);
        int i = this.jdField_a_of_type_Bboe.a(localbbnr);
        paramView = aroo.a(paramView.findViewById(2131378475), localbbnr.jdField_c_of_type_JavaLangString);
        aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Long, localbbpe, String.valueOf(localbbnr.jdField_b_of_type_Long), localbbnr.jdField_c_of_type_Int, i, this.jdField_a_of_type_Int, paramView, false, false);
        return;
      case 13: 
        this.jdField_a_of_type_Bboe.f(localbbnr);
        return;
      }
      this.jdField_a_of_type_Bboe.a(localbbnr, this.jdField_a_of_type_AndroidContentContext.getString(2131698189), this.jdField_a_of_type_AndroidContentContext.getString(2131698190));
      return;
    }
    paramView = new Intent();
    paramView.putExtra(baca.e, this.jdField_a_of_type_Long);
    paramView.putExtra("folderPath", localbbnr.jdField_b_of_type_JavaLangString);
    paramView.putExtra("folderName", localbbnr.jdField_c_of_type_JavaLangString);
    paramView.putExtra("param_from", 2000);
    TroopFileProxyActivity.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if (paramView.getId() == 2131378471) {}
      while ((paramView != null) && ((paramView instanceof CircleFileStateView)))
      {
        ((CircleFileStateView)paramView).setState(paramInt);
        return;
        paramView = paramView.findViewById(2131378471);
      }
    }
  }
  
  public void a(bbrk parambbrk)
  {
    this.jdField_a_of_type_Bbrk = parambbrk;
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if ((this.jdField_a_of_type_Bbnr != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bbnr.a(paramQQAppInterface, paramLong)))) {}
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
    if (this.jdField_a_of_type_Bbnr == null) {}
    while (this.jdField_a_of_type_Bbnr.jdField_d_of_type_Boolean) {
      return;
    }
    if (bdcs.b(this.jdField_a_of_type_Bbnr.i))
    {
      i = arni.a(this.jdField_a_of_type_Bbnr.jdField_c_of_type_JavaLangString);
      arni.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, this.jdField_a_of_type_Bbnr.i, i);
      return;
    }
    int i = arni.b(this.jdField_a_of_type_Bbnr.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView.setDefaultImage(i);
  }
  
  protected void b(View paramView)
  {
    bbnr localbbnr = a(paramView);
    if (localbbnr == null) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    switch (localbbnr.e)
    {
    case 4: 
    case 5: 
    default: 
      return;
    case 0: 
    case 1: 
      localTroopFileTransferManager.a(localbbnr.jdField_a_of_type_JavaUtilUUID);
      a(paramView, 3);
      return;
    case 2: 
      this.jdField_a_of_type_Bboe.a(localbbnr.jdField_a_of_type_JavaUtilUUID);
      return;
    case 3: 
      this.jdField_a_of_type_Bboe.c(localbbnr);
      return;
    case 8: 
      localTroopFileTransferManager.d(localbbnr.jdField_a_of_type_JavaUtilUUID);
      a(paramView, 2);
      return;
    case 9: 
      this.jdField_a_of_type_Bboe.b(localbbnr.jdField_a_of_type_JavaUtilUUID);
      return;
    case 10: 
      this.jdField_a_of_type_Bboe.d(localbbnr);
      a(paramView, 2);
      return;
    case 6: 
    case 11: 
      paramView = this.jdField_a_of_type_Bboe.a(localbbnr);
      int i = this.jdField_a_of_type_Bboe.a(localbbnr);
      aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, null, null, this.jdField_a_of_type_Long, paramView, String.valueOf(localbbnr.jdField_b_of_type_Long), localbbnr.jdField_c_of_type_Int, i, this.jdField_a_of_type_Int, null, false, false);
      return;
    case 7: 
      this.jdField_a_of_type_Bboe.a(localbbnr.jdField_b_of_type_JavaLangString, localbbnr.jdField_c_of_type_JavaLangString, localbbnr.jdField_a_of_type_Long, localbbnr.jdField_a_of_type_Int);
      a(paramView, 2);
      return;
    case 13: 
      this.jdField_a_of_type_Bboe.f(localbbnr);
      a(paramView, 1);
      return;
    }
    this.jdField_a_of_type_Bboe.a(localbbnr, this.jdField_a_of_type_AndroidContentContext.getString(2131698189), this.jdField_a_of_type_AndroidContentContext.getString(2131698190));
    a(paramView, 2);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected void c(View paramView)
  {
    paramView = a((TextView)paramView.findViewById(2131378473));
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
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentContext.getString(2131692553);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrf
 * JD-Core Version:    0.7.0.1
 */