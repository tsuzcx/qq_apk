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
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeLabelTextView;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class betb
  extends alif
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private final besj jdField_a_of_type_Besj;
  besq jdField_a_of_type_Besq;
  private final besy jdField_a_of_type_Besy;
  private bete jdField_a_of_type_Bete;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  String jdField_a_of_type_JavaLangString;
  LinkedHashMap<ajac, bess> jdField_a_of_type_JavaUtilLinkedHashMap;
  private List<ajac> jdField_a_of_type_JavaUtilList;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt = new int[0];
  private String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  boolean b;
  private boolean c;
  
  public betb(besy parambesy, TroopChatPie paramTroopChatPie)
  {
    super(parambesy.jdField_a_of_type_AndroidContentContext, parambesy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambesy.jdField_a_of_type_ComTencentWidgetXListView, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = parambesy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = parambesy.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_Besy = parambesy;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    f();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_Besj = new besj(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    this.jdField_a_of_type_Bete = new bete(this);
    d();
  }
  
  private void a(int paramInt, betd parambetd)
  {
    ajac localajac = (ajac)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    parambetd.c.setImageBitmap(a(localajac.jdField_a_of_type_JavaLangString, 2));
    Object localObject = best.b(localajac);
    if (this.jdField_a_of_type_Int == 1) {
      localObject = localajac.v;
    }
    localObject = new bczs((CharSequence)localObject, 16).a();
    parambetd.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    bgdk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambetd.jdField_a_of_type_AndroidWidgetTextView, (Spannable)localObject);
    parambetd.jdField_a_of_type_JavaLangString = localajac.jdField_a_of_type_JavaLangString;
    parambetd.jdField_a_of_type_Int = paramInt;
    betd.a(parambetd).setTag(parambetd);
    betd.a(parambetd).setOnClickListener(this);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources(), parambetd, localajac);
    c(parambetd, localajac);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localajac))
    {
      parambetd.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      if (this.jdField_a_of_type_Bete.jdField_a_of_type_Boolean) {
        break label209;
      }
      parambetd.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
    }
    for (;;)
    {
      a(parambetd, localajac);
      b(parambetd, localajac);
      return;
      parambetd.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break;
      label209:
      parambetd.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
    }
  }
  
  private void a(ajac paramajac)
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
      if (((ajac)((Map.Entry)localObject1).getKey()).equals(paramajac)) {
        localObject1 = (bess)((Map.Entry)localObject1).getValue();
      }
    }
    else
    {
      paramajac = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      j = 0;
      label98:
      if (!paramajac.hasNext()) {
        break label241;
      }
      localEntry = (Map.Entry)paramajac.next();
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
        localObject2 = (bess)localEntry.getValue();
        int m = ((bess)localObject2).jdField_a_of_type_Int - ((bess)localObject1).jdField_a_of_type_AndroidTextSpannableString.length();
        int k = m;
        if (m < 0) {
          k = 0;
        }
        localObject2 = new bess(k, ((bess)localObject2).jdField_a_of_type_AndroidTextSpannableString);
        localLinkedHashMap.put(localEntry.getKey(), localObject2);
      }
    }
    label241:
    this.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
  }
  
  private void a(View paramView)
  {
    paramView = ((betd)paramView.getTag()).jdField_a_of_type_AndroidWidgetCheckBox;
    if ((this.jdField_a_of_type_Bete.a()) && (!paramView.isChecked())) {
      this.jdField_a_of_type_Bete.b();
    }
    do
    {
      return;
      this.jdField_a_of_type_Besj.b();
    } while (!this.jdField_a_of_type_Besj.a());
    ajac localajac = (ajac)getItem(0);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      c(localajac);
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
      this.jdField_a_of_type_Besj.a();
      if ((this.jdField_a_of_type_Bete.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Besq == null)) {
        break;
      }
      this.jdField_a_of_type_Besq.a();
      return;
      b(localajac);
      a(localajac);
      break label79;
    }
  }
  
  private void a(betd parambetd)
  {
    if (!this.c) {
      this.c = true;
    }
    this.jdField_a_of_type_Besj.a(parambetd.jdField_a_of_type_AndroidWidgetRelativeLayout);
    parambetd.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.getCurFriendUin();
    this.jdField_a_of_type_Besj.a((String)localObject);
    this.jdField_a_of_type_Bete.a(parambetd.c);
    localObject = (ajac)this.jdField_a_of_type_JavaUtilList.get(0);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localObject)) {
      parambetd.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    while (!this.jdField_a_of_type_Bete.jdField_a_of_type_Boolean)
    {
      parambetd.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      return;
      parambetd.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    parambetd.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
  }
  
  private void a(betd parambetd, ajac paramajac)
  {
    if (parambetd.jdField_a_of_type_AndroidViewView != null)
    {
      bfdm localbfdm = (bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if ((localbfdm == null) || (!localbfdm.b(paramajac.jdField_a_of_type_JavaLangString))) {
        break label54;
      }
    }
    label54:
    for (int i = 1; i != 0; i = 0)
    {
      parambetd.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    parambetd.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void b(ajac paramajac)
  {
    paramajac = (bess)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramajac);
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input.getEditableText();
    if (paramajac != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QuickAtListAdapter", 2, "deleteAtSpan: invoked.  editableText: " + localEditable + " need delete atTag: " + paramajac);
      }
      int i = paramajac.jdField_a_of_type_Int;
      int j = paramajac.jdField_a_of_type_Int;
      localEditable.delete(i, paramajac.jdField_a_of_type_AndroidTextSpannableString.length() + j);
      if (QLog.isColorLevel()) {
        QLog.d("QuickAtListAdapter", 2, new Object[] { "deleteAtSpan: invoked. ", " after delete, editableText: ", localEditable });
      }
    }
  }
  
  private void b(View paramView)
  {
    boolean bool = true;
    Object localObject = (betd)paramView.getTag();
    paramView = ((betd)localObject).jdField_a_of_type_AndroidWidgetCheckBox;
    ajac localajac = (ajac)getItem(((betd)localObject).jdField_a_of_type_Int);
    this.jdField_a_of_type_Boolean = true;
    if (!paramView.isChecked())
    {
      if (this.jdField_a_of_type_Bete.a())
      {
        this.jdField_a_of_type_Bete.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      c(localajac);
      if (paramView.isChecked()) {
        break label231;
      }
      label76:
      paramView.setChecked(bool);
      this.jdField_a_of_type_Boolean = false;
      paramView = (bfdm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
      if (((this.jdField_a_of_type_Besq != null) && (paramView.b(localajac.jdField_a_of_type_JavaLangString))) || ((this.jdField_a_of_type_Besq != null) && (!this.jdField_a_of_type_Bete.jdField_a_of_type_Boolean))) {
        this.jdField_a_of_type_Besq.a();
      }
      localObject = "1";
      if ((TextUtils.isEmpty(localajac.v)) || (!localajac.v.equals(localajac.m))) {
        break label236;
      }
      paramView = "2";
    }
    for (;;)
    {
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A492", "0X800A492", 0, 0, paramView, "", "", "");
      return;
      b(localajac);
      a(localajac);
      break;
      label231:
      bool = false;
      break label76;
      label236:
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(localajac.v))
      {
        paramView = (View)localObject;
        if (localajac.v.equals(localajac.g)) {
          paramView = "3";
        }
      }
    }
  }
  
  private void b(betd parambetd, ajac paramajac)
  {
    if (parambetd.b != null)
    {
      if (paramajac.jdField_a_of_type_Boolean)
      {
        paramajac = TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), Color.parseColor("#FE988A"));
        parambetd.b.setBackgroundDrawable(paramajac);
        parambetd.b.setVisibility(0);
      }
    }
    else {
      return;
    }
    parambetd.b.setVisibility(8);
  }
  
  private void c(ajac paramajac)
  {
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramajac)) {
      QLog.d("QuickAtListAdapter", 1, new Object[] { "insertAtSpan: invoked. ", "already exists member: ", paramajac });
    }
    Object localObject;
    do
    {
      return;
      localObject = best.a(paramajac);
      localObject = bevq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.mActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin, paramajac.jdField_a_of_type_JavaLangString, (String)localObject, best.a(paramajac), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    Editable localEditable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input.getEditableText();
    int m = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input.getSelectionStart();
    int n = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input.getText().toString().lastIndexOf("@", m);
    int j;
    if ((n != -1) && (best.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.input) < n)) {
      j = 1;
    }
    for (int i = n;; i = m)
    {
      int k = i;
      if (i < 0) {
        k = 0;
      }
      bess localbess = new bess(k, (SpannableString)localObject);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramajac, localbess);
      if (j != 0) {
        localEditable.delete(n, m);
      }
      localEditable.insert(k, (CharSequence)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("QuickAtListAdapter", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localbess, " editableText: ", localEditable });
      return;
      j = 0;
    }
  }
  
  private void c(betd parambetd, ajac paramajac)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramajac.jdField_a_of_type_JavaLangString))
    {
      betd.a(parambetd).setVisibility(0);
      paramajac = beda.a().a(true, false);
      betd.a(parambetd).setText(paramajac.jdField_a_of_type_JavaLangString);
      paramajac = TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramajac.b);
      betd.a(parambetd).setBackgroundDrawable(paramajac);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopAdmin(paramajac.jdField_a_of_type_JavaLangString))
    {
      betd.a(parambetd).setVisibility(0);
      paramajac = beda.a().a(false, true);
      betd.a(parambetd).setText(paramajac.jdField_a_of_type_JavaLangString);
      paramajac = TroopUtils.getTroopLevelBgDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramajac.b);
      betd.a(parambetd).setBackgroundDrawable(paramajac);
      return;
    }
    betd.a(parambetd).setVisibility(8);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Besy.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new betc(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickAtListAdapter", 2, new Object[] { "updateIndexLetters: invoked. ", " TAG: ", "QuickAtListAdapter" });
    }
    IndexBar localIndexBar = this.jdField_a_of_type_Besy.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (localIndexBar != null) {
      localIndexBar.setLetters(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
  }
  
  private void f()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.sessionInfo.curFriendUin;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(str);
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
  
  ajac a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int j = this.jdField_a_of_type_JavaUtilList.size();
      int i = 0;
      while (i < j)
      {
        ajac localajac = (ajac)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localajac.jdField_a_of_type_JavaLangString != null) && (localajac.jdField_a_of_type_JavaLangString.equals(paramString))) {
          return localajac;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public bete a()
  {
    return this.jdField_a_of_type_Bete;
  }
  
  public List<ajac> a()
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
    paramView = this.jdField_a_of_type_Besy.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar;
    if (paramView != null) {
      paramView.setChooseIndex(paramInt);
    }
  }
  
  public void a(besq parambesq)
  {
    this.jdField_a_of_type_Besq = parambesq;
  }
  
  public void a(betg parambetg)
  {
    this.jdField_a_of_type_JavaUtilList = parambetg.jdField_a_of_type_JavaUtilList;
    this.jdField_a_of_type_ArrayOfInt = parambetg.jdField_a_of_type_ArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambetg.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_JavaLangString = parambetg.jdField_a_of_type_JavaLangString;
    this.b = parambetg.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Besj.a();
    if (TextUtils.isEmpty(parambetg.jdField_a_of_type_JavaLangString))
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
  
  public void a(List<ajac> paramList)
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
    return "0".equals(((ajac)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
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
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A491", "0X800A491", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_Bete.jdField_a_of_type_Boolean = false;
      return;
      label72:
      if (i > 1) {
        bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A490", "0X800A490", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Besj != null) {
      this.jdField_a_of_type_Besj.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
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
    label37:
    betd localbetd;
    if (getItemViewType(paramInt) == 1)
    {
      i = 1;
      if (paramView != null) {
        break label105;
      }
      if (i == 0) {
        break label86;
      }
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562926, paramViewGroup, false);
      localbetd = new betd(paramView);
      paramView.setTag(localbetd);
      label53:
      if (i == 0) {
        break label117;
      }
      a(localbetd);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      i = 0;
      break;
      label86:
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562925, paramViewGroup, false);
      break label37;
      label105:
      localbetd = (betd)paramView.getTag();
      break label53;
      label117:
      a(paramInt, localbetd);
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(paramView);
      continue;
      a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     betb
 * JD-Core Version:    0.7.0.1
 */