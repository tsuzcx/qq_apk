import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.view.IndexBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class bcdm
  extends akdk
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final bccu jdField_a_of_type_Bccu;
  bcdb jdField_a_of_type_Bcdb;
  private final bcdj jdField_a_of_type_Bcdj;
  private bcdp jdField_a_of_type_Bcdp;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<ahyq, bcdd> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<ahyq> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public bcdm(bcdj parambcdj, TroopChatPie paramTroopChatPie)
  {
    super(parambcdj.jdField_a_of_type_AndroidContentContext, parambcdj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambcdj.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = parambcdj.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = parambcdj.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Bcdj = parambcdj;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Bccu = new bccu(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bcdp = new bcdp(this);
    d();
  }
  
  private void a(int paramInt, bcdo parambcdo)
  {
    ahyq localahyq = (ahyq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambcdo.c.setImageBitmap(a(localahyq.jdField_a_of_type_JavaLangString, 2));
    Object localObject = bcde.b(localahyq);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localahyq.v;
    }
    localObject = new bahs((CharSequence)localObject, 16).a();
    parambcdo.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bdnm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambcdo.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject);
    parambcdo.jdField_a_of_type_JavaLangString = localahyq.jdField_a_of_type_JavaLangString;
    parambcdo.jdField_a_of_type_Int = paramInt;
    bcdo.a(parambcdo).setTag(parambcdo);
    bcdo.a(parambcdo).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), parambcdo, localahyq);
    c(parambcdo, localahyq);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localahyq))
    {
      parambcdo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Bcdp.jdField_a_of_type_Boolean) {
        break label209;
      }
      parambcdo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parambcdo, localahyq);
      b(parambcdo, localahyq);
      return;
      parambcdo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label209:
      parambcdo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(ahyq paramahyq)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Map.Entry localEntry = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int i = 0;
    Object localObject1 = localEntry;
    int j;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      if (((ahyq)((Map.Entry)localObject1).getKey()).equals(paramahyq)) {
        localObject1 = (bcdd)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramahyq = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramahyq.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramahyq.next();
      if (j >= i) {
        break label157;
      }
      localLinkedHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    for (;;)
    {
      j += 1;
      break label98;
      i += 1;
      break;
      label157:
      if ((j != i) && (localObject1 != null))
      {
        localObject2 = (bcdd)localEntry.getValue();
        int m = ((bcdd)localObject2).jdField_a_of_type_Int - ((bcdd)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new bcdd(k, ((bcdd)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((bcdo)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Bcdp.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Bcdp.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Bccu.b();
    } while (!this.jdField_a_of_type_Bccu.a());
    ahyq localahyq = (ahyq)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localahyq);
      label79:
      if (paramView.isChecked()) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Bccu.a();
      if ((this.jdField_a_of_type_Bcdp.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Bcdb == null)) {
        break;
      }
      this.jdField_a_of_type_Bcdb.a();
      return;
      b(localahyq);
      a(localahyq);
      break label79;
    }
  }
  
  private void a(bcdo parambcdo)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Bccu.a(parambcdo.jdField_a_of_type_AndroidWidgetRelativeLayout);
    parambcdo.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.a();
    this.jdField_a_of_type_Bccu.a((String)localObject);
    this.jdField_a_of_type_Bcdp.a(parambcdo.c);
    localObject = (ahyq)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      parambcdo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Bcdp.jdField_a_of_type_Boolean)
    {
      parambcdo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      parambcdo.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    parambcdo.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(bcdo parambcdo, ahyq paramahyq)
  {
    if (parambcdo.jdField_a_of_type_AndroidViewView != null)
    {
      bckx localbckx = (bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localbckx == null) || (!localbckx.b(paramahyq.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parambcdo.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambcdo.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(ahyq paramahyq)
  {
    paramahyq = (bcdd)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramahyq);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (paramahyq != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramahyq);
      }
      int i = paramahyq.jdField_a_of_type_Int;
      int j = paramahyq.jdField_a_of_type_Int;
      localEditable.delete(i, paramahyq.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (bcdo)paramView.getTag();
    paramView = ((bcdo)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    ahyq localahyq = (ahyq)getItem(((bcdo)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Bcdp.a())
      {
        this.jdField_a_of_type_Bcdp.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localahyq);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (bckx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (((this.jdField_a_of_type_Bcdb != null) && (paramView.b(localahyq.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Bcdb != null) && (!this.jdField_a_of_type_Bcdp.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Bcdb.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localahyq.v)) || (!localahyq.v.equals(localahyq.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localahyq);
      a(localahyq);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localahyq.v))
      {
        paramView = (View)localObject;
        if (localahyq.v.equals(localahyq.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(bcdo parambcdo, ahyq paramahyq)
  {
    if (parambcdo.b != null)
    {
      if (paramahyq.jdField_a_of_type_Boolean)
      {
        paramahyq = bclo.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        parambcdo.b.setBackgroundDrawable(paramahyq);
        parambcdo.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    parambcdo.b.setVisibility(8);
  }
  
  private void c(ahyq paramahyq)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramahyq)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramahyq });
    }
    Object localObject;
    do
    {
      return;
      localObject = bcde.a(paramahyq);
      localObject = bceh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramahyq.jdField_a_of_type_JavaLangString, (String)localObject, bcde.a(paramahyq), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (bcde.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      bcdd localbcdd = new bcdd(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramahyq, localbcdd);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localbcdd, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(bcdo parambcdo, ahyq paramahyq)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramahyq.jdField_a_of_type_JavaLangString))
    {
      bcdo.a(parambcdo).setVisibility(0);
      paramahyq = bbpo.a().a(true, false);
      bcdo.a(parambcdo).setText(paramahyq.jdField_a_of_type_JavaLangString);
      paramahyq = bclo.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramahyq.b);
      bcdo.a(parambcdo).setBackgroundDrawable(paramahyq);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(paramahyq.jdField_a_of_type_JavaLangString))
    {
      bcdo.a(parambcdo).setVisibility(0);
      paramahyq = bbpo.a().a(false, true);
      bcdo.a(parambcdo).setText(paramahyq.jdField_a_of_type_JavaLangString);
      paramahyq = bclo.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramahyq.b);
      bcdo.a(parambcdo).setBackgroundDrawable(paramahyq);
      return;
    }
    bcdo.a(parambcdo).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bcdj.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bcdn(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Bcdj.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(String paramString)
  {
    int i;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      i = 0;
      if (i >= this.jdField_a_of_type_ArrayOfJavaLangString.length) {
        break label53;
      }
      if (!this.jdField_a_of_type_ArrayOfJavaLangString[i].equals(paramString)) {}
    }
    for (;;)
    {
      if (i >= 0)
      {
        return this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
        break;
      }
      return -1;
      return -1;
      label53:
      i = -1;
    }
  }
  
  ahyq a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        ahyq localahyq = (ahyq)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localahyq.jdField_a_of_type_JavaLangString != null) && (localahyq.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localahyq;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public bcdp a()
  {
    return this.jdField_a_of_type_Bcdp;
  }
  
  public List<ahyq> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return localArrayList;
    }
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localArrayList;
  }
  
  public void a()
  {
    this.c = false;
  }
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_Bcdj.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(bcdb parambcdb)
  {
    this.jdField_a_of_type_Bcdb = parambcdb;
  }
  
  public void a(bcdr parambcdr)
  {
    this.jdField_a_of_type_JavaUtilList = parambcdr.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = parambcdr.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambcdr.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = parambcdr.jdField_a_of_type_JavaLangString;
    this.b = parambcdr.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bccu.a();
    if (TextUtils.isEmpty(parambcdr.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    }
    for (;;)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged start  " + System.currentTimeMillis());
      }
      notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.e("QuickAtListAdapter", 2, "taa notifySearchDataChanged end  " + System.currentTimeMillis());
      }
      return;
      this.jdField_a_of_type_Int = 1;
    }
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "unCheckItem ", paramString.toString() });
    }
    a(paramString);
    notifyDataSetChanged();
  }
  
  public void a(List<ahyq> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return false;
    }
    return "0".equals(((ahyq)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    int i;
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap != null)
    {
      i = this.jdField_a_of_type_JavaUtilLinkedHashMap.size();
      if (i != 1) {
        break label72;
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Bcdp.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bccu != null) {
      this.jdField_a_of_type_Bccu.c();
    }
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == 0) && (a())) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label88;
      }
      if (i == 0) {
        break label69;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562754, paramViewGroup, false);
      label37:
      paramViewGroup = new bcdo(paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      if (i == 0) {
        break label99;
      }
      a(paramViewGroup);
      return paramView;
      i = 0;
      break;
      label69:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562753, paramViewGroup, false);
      break label37;
      label88:
      paramViewGroup = (bcdo)paramView.getTag();
    }
    label99:
    a(paramInt, paramViewGroup);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368516: 
      b(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdm
 * JD-Core Version:    0.7.0.1
 */