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
import com.tencent.mobileqq.activity.contacts.view.IndexBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
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

public class azdr
  extends ahzi
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private final aejb jdField_a_of_type_Aejb;
  private Context jdField_a_of_type_AndroidContentContext;
  private final azcz jdField_a_of_type_Azcz;
  azdg jdField_a_of_type_Azdg;
  private final azdo jdField_a_of_type_Azdo;
  private azdu jdField_a_of_type_Azdu;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<afou, azdi> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<afou> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public azdr(azdo paramazdo, aejb paramaejb)
  {
    super(paramazdo.jdField_a_of_type_AndroidContentContext, paramazdo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazdo.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramazdo.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramazdo.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Azdo = paramazdo;
    this.jdField_a_of_type_Aejb = paramaejb;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Azcz = new azcz(this.jdField_a_of_type_Aejb, this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Azdu = new azdu(this);
    d();
  }
  
  private void a(int paramInt, azdt paramazdt)
  {
    afou localafou = (afou)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramazdt.c.setImageBitmap(a(localafou.jdField_a_of_type_JavaLangString, 2));
    Object localObject = azdj.b(localafou);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localafou.v;
    }
    localObject = new axjq((CharSequence)localObject, 16).a();
    paramazdt.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bami.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazdt.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject);
    paramazdt.jdField_a_of_type_JavaLangString = localafou.jdField_a_of_type_JavaLangString;
    paramazdt.jdField_a_of_type_Int = paramInt;
    azdt.a(paramazdt).setTag(paramazdt);
    azdt.a(paramazdt).setOnClickListener(this);
    bajr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), paramazdt, localafou);
    c(paramazdt, localafou);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localafou))
    {
      paramazdt.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Azdu.jdField_a_of_type_Boolean) {
        break label209;
      }
      paramazdt.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(paramazdt, localafou);
      b(paramazdt, localafou);
      return;
      paramazdt.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label209:
      paramazdt.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(afou paramafou)
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
      if (((afou)((Map.Entry)localObject1).getKey()).equals(paramafou)) {
        localObject1 = (azdi)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramafou = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramafou.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramafou.next();
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
        localObject2 = (azdi)localEntry.getValue();
        int m = ((azdi)localObject2).jdField_a_of_type_Int - ((azdi)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new azdi(k, ((azdi)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((azdt)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Azdu.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Azdu.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Azcz.b();
    } while (!this.jdField_a_of_type_Azcz.a());
    afou localafou = (afou)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localafou);
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
      this.jdField_a_of_type_Azcz.a();
      if ((this.jdField_a_of_type_Azdu.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Azdg == null)) {
        break;
      }
      this.jdField_a_of_type_Azdg.a();
      return;
      b(localafou);
      a(localafou);
      break label79;
    }
  }
  
  private void a(azdt paramazdt)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Azcz.a(paramazdt.jdField_a_of_type_AndroidWidgetRelativeLayout);
    paramazdt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_Aejb.a();
    this.jdField_a_of_type_Azcz.a((String)localObject);
    this.jdField_a_of_type_Azdu.a(paramazdt.c);
    localObject = (afou)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      paramazdt.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Azdu.jdField_a_of_type_Boolean)
    {
      paramazdt.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      paramazdt.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    paramazdt.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(azdt paramazdt, afou paramafou)
  {
    if (paramazdt.jdField_a_of_type_AndroidViewView != null)
    {
      azks localazks = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localazks == null) || (!localazks.b(paramafou.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      paramazdt.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    paramazdt.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(afou paramafou)
  {
    paramafou = (azdi)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramafou);
    Editable localEditable = this.jdField_a_of_type_Aejb.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    if (paramafou != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramafou);
      }
      int i = paramafou.jdField_a_of_type_Int;
      int j = paramafou.jdField_a_of_type_Int;
      localEditable.delete(i, paramafou.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (azdt)paramView.getTag();
    paramView = ((azdt)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    afou localafou = (afou)getItem(((azdt)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Azdu.a())
      {
        this.jdField_a_of_type_Azdu.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localafou);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (azks)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (((this.jdField_a_of_type_Azdg != null) && (paramView.b(localafou.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Azdg != null) && (!this.jdField_a_of_type_Azdu.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Azdg.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localafou.v)) || (!localafou.v.equals(localafou.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localafou);
      a(localafou);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localafou.v))
      {
        paramView = (View)localObject;
        if (localafou.v.equals(localafou.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(azdt paramazdt, afou paramafou)
  {
    if (paramazdt.b != null)
    {
      if (paramafou.jdField_a_of_type_Boolean)
      {
        paramafou = azlj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        paramazdt.b.setBackgroundDrawable(paramafou);
        paramazdt.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    paramazdt.b.setVisibility(8);
  }
  
  private void c(afou paramafou)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramafou)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramafou });
    }
    Object localObject;
    do
    {
      return;
      localObject = azdj.a(paramafou);
      localObject = azef.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aejb.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Aejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramafou.jdField_a_of_type_JavaLangString, (String)localObject, azdj.a(paramafou), this.jdField_a_of_type_Aejb.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_Aejb.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int m = this.jdField_a_of_type_Aejb.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    int n = this.jdField_a_of_type_Aejb.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (azdj.b(this.jdField_a_of_type_Aejb.jdField_a_of_type_ComTencentWidgetXEditTextEx) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      azdi localazdi = new azdi(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramafou, localazdi);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localazdi, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(azdt paramazdt, afou paramafou)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(paramafou.jdField_a_of_type_JavaLangString))
    {
      azdt.a(paramazdt).setVisibility(0);
      paramafou = ayqn.a().a(true, false);
      azdt.a(paramazdt).setText(paramafou.jdField_a_of_type_JavaLangString);
      paramafou = azlj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramafou.b);
      azdt.a(paramazdt).setBackgroundDrawable(paramafou);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopAdmin(paramafou.jdField_a_of_type_JavaLangString))
    {
      azdt.a(paramazdt).setVisibility(0);
      paramafou = ayqn.a().a(false, true);
      azdt.a(paramazdt).setText(paramafou.jdField_a_of_type_JavaLangString);
      paramafou = azlj.a(this.jdField_a_of_type_AndroidContentContext.getResources(), paramafou.b);
      azdt.a(paramazdt).setBackgroundDrawable(paramafou);
      return;
    }
    azdt.a(paramazdt).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Azdo.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new azds(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Azdo.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_Aejb.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
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
  
  afou a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        afou localafou = (afou)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localafou.jdField_a_of_type_JavaLangString != null) && (localafou.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localafou;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public azdu a()
  {
    return this.jdField_a_of_type_Azdu;
  }
  
  public List<afou> a()
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
    paramView = this.jdField_a_of_type_Azdo.jdField_a_of_type_ComTencentMobileqqActivityContactsViewIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(azdg paramazdg)
  {
    this.jdField_a_of_type_Azdg = paramazdg;
  }
  
  public void a(azdw paramazdw)
  {
    this.jdField_a_of_type_JavaUtilList = paramazdw.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = paramazdw.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramazdw.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = paramazdw.jdField_a_of_type_JavaLangString;
    this.b = paramazdw.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Azcz.a();
    if (TextUtils.isEmpty(paramazdw.jdField_a_of_type_JavaLangString))
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
  
  public void a(List<afou> paramList)
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
    return "0".equals(((afou)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
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
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Azdu.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Azcz != null) {
      this.jdField_a_of_type_Azcz.c();
    }
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496953, paramViewGroup, false);
      label37:
      paramViewGroup = new azdt(paramView);
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496952, paramViewGroup, false);
      break label37;
      label88:
      paramViewGroup = (azdt)paramView.getTag();
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
    case 2131302722: 
      b(paramView);
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdr
 * JD-Core Version:    0.7.0.1
 */