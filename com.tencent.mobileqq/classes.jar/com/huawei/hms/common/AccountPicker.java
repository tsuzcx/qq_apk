package com.huawei.hms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

public final class AccountPicker
{
  public static final String CHOOSE_ACCOUNT = "com.huawei.hms.common.account.CHOOSE_ACCOUNT";
  public static final int CUSTOM_THEME_ACCOUNT_CHIPS = 2;
  public static final int CUSTOM_THEME_GAMES = 1;
  public static final int CUSTOM_THEME_NONE = 0;
  public static final String EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING = "authTokenType";
  public static final String EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE = "addAccountOptions";
  public static final String EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY = "addAccountRequiredFeatures";
  public static final String EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST = "allowableAccounts";
  public static final String EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY = "allowableAccountTypes";
  public static final String EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT = "alwaysPromptForAccount";
  public static final String EXTRA_DESCRIPTION_TEXT_OVERRIDE = "descriptionTextOverride";
  public static final String EXTRA_HOSTED_DOMAIN_FILTER = "hostedDomainFilter";
  public static final String EXTRA_IS_ACCOUNT_CHIPS_ACCOUNT_PICKER = "pickedFromAccountChips";
  public static final String EXTRA_OVERRIDE_CUSTOM_THEME = "overrideCustomTheme";
  public static final String EXTRA_OVERRIDE_THEME = "overrideTheme";
  public static final String EXTRA_REAL_CLIENT_PACKAGE = "realClientPackage";
  public static final String EXTRA_SELECTED_ACCOUNT = "selectedAccount";
  public static final String EXTRA_SET_HMS_CORE_ACCOUNT = "setHmsCoreAccount";
  private static final String HMS_PACKAGE = "com.huawei.hms";
  public static final int THEME_DEFAULT = 0;
  public static final int THEME_LIGHT = 1;
  
  public static Intent newChooseAccountIntent(Account paramAccount, ArrayList<Account> paramArrayList, String[] paramArrayOfString1, boolean paramBoolean, String paramString1, String paramString2, String[] paramArrayOfString2, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.huawei.hms.common.account.CHOOSE_ACCOUNT");
    localIntent.setPackage("com.huawei.hms");
    localIntent.putExtra("allowableAccounts", paramArrayList);
    localIntent.putExtra("allowableAccountTypes", paramArrayOfString1);
    localIntent.putExtra("addAccountOptions", paramBundle);
    localIntent.putExtra("selectedAccount", paramAccount);
    localIntent.putExtra("alwaysPromptForAccount", paramBoolean);
    localIntent.putExtra("descriptionTextOverride", paramString1);
    localIntent.putExtra("authTokenType", paramString2);
    localIntent.putExtra("addAccountRequiredFeatures", paramArrayOfString2);
    localIntent.putExtra("setHmsCoreAccount", false);
    localIntent.putExtra("overrideTheme", 0);
    localIntent.putExtra("overrideCustomTheme", 0);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.AccountPicker
 * JD-Core Version:    0.7.0.1
 */